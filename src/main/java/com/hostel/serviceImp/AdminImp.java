package com.hostel.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.entity.AdminEntity;
import com.hostel.entity.StudentEntity;
import com.hostel.exceptions.ResourceNotFoundException;
import com.hostel.payload.AdminDto;
import com.hostel.payload.StudentDto;
import com.hostel.repo.AdminRepository;
import com.hostel.service.AdminSer;

@Service
public class AdminImp implements AdminSer {

	@Autowired

	private AdminRepository adminRepo;

	@Override
	public AdminDto createAdmin(AdminDto adminDto) {
		AdminEntity admin = this.adminDtoToAdmin(adminDto);
		AdminEntity saveAdmin = this.adminRepo.save(admin);
		return this.adminToAdminDto(saveAdmin);
	}

	
	
	@Override
	public List<AdminDto> getAdmins() {
		List<AdminEntity> adminRecordsEntity = this.adminRepo.findAll();
		List<AdminDto> adminRecordsDto = adminRecordsEntity.stream().map(admin1 -> this.adminToAdminDto(admin1))
				.collect(Collectors.toList());
		return adminRecordsDto;

	}

	@Override
	public AdminDto getAdminById(int admin_id) {
		AdminEntity admin=this.adminRepo.findById(admin_id).orElseThrow(
				()->new ResourceNotFoundException("admin","adminId",admin_id));
		return this.adminToAdminDto(admin); //dto for fetching
	}

	@Override
	public AdminDto updateAdminById(AdminDto adminDto, int admin_id) {
		AdminEntity admin=this.adminRepo.findById(admin_id).orElseThrow(()-> new ResourceNotFoundException("admin","Admin_id",admin_id));
		admin.setAdmin_name(adminDto.getAdmin_name());
		admin.setAdmin_contact(adminDto.getAdmin_contact());
		admin.setHostel_id(adminDto.getHostel_id());
	
		this.adminRepo.save(admin);
		return this.adminToAdminDto(admin);
	}

	@Override
	public void deleteAdminById(int admin_id) {
	  AdminEntity admin=this.adminRepo.findById(admin_id).orElseThrow(
			  ()->new ResourceNotFoundException("admin","adminId",admin_id));
		this.adminRepo.delete(admin);
	}
	
	private AdminDto adminToAdminDto(AdminEntity admin) {
		AdminDto adminDto = new AdminDto();
		adminDto.setAdmin_id(admin.getAdmin_id());
		adminDto.setHostel_id(admin.getHostel_id());
		adminDto.setAdmin_name(admin.getAdmin_name());
		adminDto.setAdmin_contact(admin.getAdmin_contact());

		return adminDto;
	}

	private AdminEntity adminDtoToAdmin(AdminDto adminDto) {
		AdminEntity admin = new AdminEntity();
		admin.setAdmin_id(adminDto.getAdmin_id());
		admin.setAdmin_name(adminDto.getAdmin_name());
		admin.setAdmin_contact(adminDto.getAdmin_contact());
		admin.setHostel_id(adminDto.getHostel_id());
	
		return admin;
	}

}