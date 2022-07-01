package com.hostel.serviceImp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.entity.HostelEntity;
import com.hostel.entity.StudentEntity;
import com.hostel.exceptions.ResourceNotFoundException;
import com.hostel.payload.HostelDto;
import com.hostel.payload.StudentDto;
import com.hostel.repo.HostelRepository;
import com.hostel.service.HostelSer;

@Service
public class HostelImp implements HostelSer {

	@Autowired
	private HostelRepository hostelRepo;
	

	@Override
	public HostelDto createHostel(HostelDto hostelDto) {
		HostelEntity hostel = this.hostelDtoToHostel(hostelDto);
		HostelEntity saveHostel = this.hostelRepo.save(hostel);
		return this.hostelToHostelDto(saveHostel);
	}

	
	@Override
	public List<HostelDto> getHostels() {
		List<HostelEntity> hostelRecordsEntity = this.hostelRepo.findAll();
		List<HostelDto> hostelRecordsDto = hostelRecordsEntity.stream().map(hostel1 -> this.hostelToHostelDto(hostel1))
				.collect(Collectors.toList());
		return hostelRecordsDto;

	}

	@Override
	public HostelDto getHostelById(int hostel_id) {
		HostelEntity hostel=this.hostelRepo.findById(hostel_id).orElseThrow(
				()->new ResourceNotFoundException("hostel","hostelId",hostel_id));
		return this.hostelToHostelDto(hostel); //dto for fetching
	}

	@Override
	public HostelDto updateHostelById(HostelDto hostelDto, int hostel_id) {
		HostelEntity hostel=this.hostelRepo.findById(hostel_id).orElseThrow(()-> new ResourceNotFoundException("hostel","Hostel_id",hostel_id));
		hostel.setHostel_id(hostelDto.getHostel_id());
		hostel.setHostel_name(hostelDto.getHostel_name());
		hostel.setHostel_admin(hostelDto.getHostel_admin());
		hostel.setNo_of_floors(hostelDto.getNo_of_floors());
		//hostel.setNo_of_student(hostelDto.getNo_of_student());
		hostel.setNo_of_wardens(hostelDto.getNo_of_wardens());
		
		this.hostelRepo.save(hostel);
		return this.hostelToHostelDto(hostel);
	}

	@Override
	public void deleteHostelById(int hostel_id) {
	  HostelEntity hostel=this.hostelRepo.findById(hostel_id).orElseThrow(
			  ()->new ResourceNotFoundException("hostel","hostelId",hostel_id));
		this.hostelRepo.delete(hostel);
	}


	private HostelDto hostelToHostelDto(HostelEntity hostel) {
		HostelDto hostelDto = new HostelDto();
		hostelDto.setHostel_id(hostel.getHostel_id());
		hostelDto.setHostel_name(hostel.getHostel_name());
		hostelDto.setHostel_admin(hostel.getHostel_admin());
	//	hostelDto.setNo_of_student(hostel.getNo_of_student());
		hostelDto.setNo_of_wardens(hostel.getNo_of_wardens());
		hostelDto.setNo_of_floors(hostel.getNo_of_floors());


		return hostelDto;
	}

	private HostelEntity hostelDtoToHostel(HostelDto hostelDto) {
		HostelEntity hostel = new HostelEntity();
		hostel.setHostel_id(hostelDto.getHostel_id());
		hostel.setHostel_name(hostelDto.getHostel_name());
		hostel.setHostel_admin(hostelDto.getHostel_admin());
	//	hostel.setNo_of_student(hostelDto.getNo_of_student());
		hostel.setNo_of_wardens(hostelDto.getNo_of_wardens());
		hostel.setNo_of_floors(hostelDto.getNo_of_floors());

		return hostel;
	
	}

}