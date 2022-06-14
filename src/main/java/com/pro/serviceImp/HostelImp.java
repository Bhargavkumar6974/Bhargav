package com.pro.serviceImp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.exceptions.ResourceNotFoundException;
import com.pro.entity.Hostel;
import com.pro.entity.Student;
import com.pro.payload.HostelDto;
import com.pro.payload.StudentDto;
import com.pro.repo.HostelRepo;
import com.pro.service.HostelSer;

@Service
public class HostelImp implements HostelSer {

	@Autowired
	private HostelRepo hostelRepo;
	

	@Override
	public HostelDto createHostel(HostelDto hostelDto) {
		Hostel hostel = this.hostelDtoToHostel(hostelDto);
		Hostel saveHostel = this.hostelRepo.save(hostel);
		return this.hostelToHostelDto(saveHostel);
	}

	
	@Override
	public List<HostelDto> getHostels() {
		List<Hostel> hostelRecordsEntity = this.hostelRepo.findAll();
		List<HostelDto> hostelRecordsDto = hostelRecordsEntity.stream().map(hostel1 -> this.hostelToHostelDto(hostel1))
				.collect(Collectors.toList());
		return hostelRecordsDto;

	}

	@Override
	public HostelDto getHostelById(int hostel_id) {
		Hostel hostel=this.hostelRepo.findById(hostel_id).orElseThrow(
				()->new ResourceNotFoundException("hostel","hostelId",hostel_id));
		return this.hostelToHostelDto(hostel); //dto for fetching
	}

	@Override
	public HostelDto updateHostelById(HostelDto hostelDto, int hostel_id) {
		Hostel hostel=this.hostelRepo.findById(hostel_id).orElseThrow(()-> new ResourceNotFoundException("hostel","Hostel_id",hostel_id));
		hostel.setHostel_id(hostelDto.getHostel_id());
		hostel.setHostel_name(hostelDto.getHostel_name());
		hostel.setHostel_admin(hostelDto.getHostel_admin());
		hostel.setNo_of_floors(hostelDto.getNo_of_floors());
		hostel.setNo_of_student(hostelDto.getNo_of_student());
		hostel.setNo_of_wardens(hostelDto.getNo_of_wardens());
		
		this.hostelRepo.save(hostel);
		return this.hostelToHostelDto(hostel);
	}

	@Override
	public void deleteHostelById(int hostel_id) {
	  Hostel hostel=this.hostelRepo.findById(hostel_id).orElseThrow(
			  ()->new ResourceNotFoundException("hostel","hostelId",hostel_id));
		this.hostelRepo.delete(hostel);
	}


	private HostelDto hostelToHostelDto(Hostel hostel) {
		HostelDto hostelDto = new HostelDto();
		hostelDto.setHostel_id(hostel.getHostel_id());
		hostelDto.setHostel_name(hostel.getHostel_name());
		hostelDto.setHostel_admin(hostel.getHostel_admin());
		hostelDto.setNo_of_student(hostel.getNo_of_student());
		hostelDto.setNo_of_wardens(hostel.getNo_of_wardens());
		hostelDto.setNo_of_floors(hostel.getNo_of_floors());


		return hostelDto;
	}

	private Hostel hostelDtoToHostel(HostelDto hostelDto) {
		Hostel hostel = new Hostel();
		hostel.setHostel_id(hostelDto.getHostel_id());
		hostel.setHostel_name(hostelDto.getHostel_name());
		hostel.setHostel_admin(hostelDto.getHostel_admin());
		hostel.setNo_of_student(hostelDto.getNo_of_student());
		hostel.setNo_of_wardens(hostelDto.getNo_of_wardens());
		hostel.setNo_of_floors(hostelDto.getNo_of_floors());

		return hostel;
	
	}

}