package com.pro.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptions.ResourceNotFoundException;
import com.pro.entity.Admin;
import com.pro.entity.Student;
import com.pro.payload.AdminDto;
import com.pro.payload.StudentDto;
import com.pro.repo.AdminRepo;
import com.pro.service.AdminSer;

@Service
public class AdminImp implements AdminSer {

	@Autowired

	private AdminRepo adminRepo;

	@Override
	public AdminDto createAdmin(AdminDto adminDto) {
		Admin admin = this.adminDtoToAdmin(adminDto);
		Admin saveAdmin = this.adminRepo.save(admin);
		return this.adminToAdminDto(saveAdmin);
	}

	
	
	@Override
	public List<AdminDto> getAdmins() {
		List<Admin> adminRecordsEntity = this.adminRepo.findAll();
		List<AdminDto> adminRecordsDto = adminRecordsEntity.stream().map(admin1 -> this.adminToAdminDto(admin1))
				.collect(Collectors.toList());
		return adminRecordsDto;

	}

	@Override
	public AdminDto getAdminById(int admin_id) {
		Admin admin=this.adminRepo.findById(admin_id).orElseThrow(
				()->new ResourceNotFoundException("admin","adminId",admin_id));
		return this.adminToAdminDto(admin); //dto for fetching
	}

	@Override
	public AdminDto updateAdminById(AdminDto adminDto, int admin_id) {
		Admin admin=this.adminRepo.findById(admin_id).orElseThrow(()-> new ResourceNotFoundException("admin","Admin_id",admin_id));
		admin.setAdmin_id(adminDto.getAdmin_id());
		admin.setAdmin_name(adminDto.getAdmin_name());
		admin.setAdmin_contact(adminDto.getAdmin_contact());
		admin.setHostel_id(adminDto.getHostel_id());
	
		this.adminRepo.save(admin);
		return this.adminToAdminDto(admin);
	}

	@Override
	public void deleteAdminById(int admin_id) {
	  Admin admin=this.adminRepo.findById(admin_id).orElseThrow(
			  ()->new ResourceNotFoundException("admin","adminId",admin_id));
		this.adminRepo.delete(admin);
	}
	
	private AdminDto adminToAdminDto(Admin admin) {
		AdminDto adminDto = new AdminDto();
		adminDto.setAdmin_id(admin.getAdmin_id());
		adminDto.setHostel_id(admin.getHostel_id());
		adminDto.setAdmin_name(admin.getAdmin_name());
		adminDto.setAdmin_contact(admin.getAdmin_contact());

		return adminDto;
	}

	private Admin adminDtoToAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setAdmin_id(adminDto.getAdmin_id());
		admin.setAdmin_name(adminDto.getAdmin_name());
		admin.setAdmin_contact(adminDto.getAdmin_contact());
		admin.setHostel_id(adminDto.getHostel_id());
	
		return admin;
	}

}