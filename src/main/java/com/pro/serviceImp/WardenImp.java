
package com.pro.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.exceptions.ResourceNotFoundException;
import com.pro.entity.Student;
import com.pro.entity.Warden;
import com.pro.payload.StudentDto;
import com.pro.payload.WardenDto;

import com.pro.repo.WardenRepo;

import com.pro.service.WardenSer;

@Service
public class WardenImp implements WardenSer {

	@Autowired

	private WardenRepo wardenRepo;

	@Override
	public WardenDto createWarden(WardenDto wardenDto) {
		Warden warden = this.wardenDtoToWarden(wardenDto);
		Warden saveWarden = this.wardenRepo.save(warden);
		return this.wardenToWardenDto(saveWarden);
	}

	
	
	@Override
	public List<WardenDto> getWardens() {
		List<Warden> wardenRecordsEntity = this.wardenRepo.findAll();
		List<WardenDto> wardenRecordsDto = wardenRecordsEntity.stream().map(warden1 -> this.wardenToWardenDto(warden1))
				.collect(Collectors.toList());
		return wardenRecordsDto;

	}

	@Override
	public WardenDto getWardenById(int warden_id) {
		Warden warden=this.wardenRepo.findById(warden_id).orElseThrow(
				()->new ResourceNotFoundException("warden","wardenId",warden_id));
		return this.wardenToWardenDto(warden); //dto for fetching
	}

	@Override
	public WardenDto updateWardenById(WardenDto wardenDto, int warden_id) {
		Warden warden=this.wardenRepo.findById(warden_id).orElseThrow(()-> new ResourceNotFoundException("warden","Warden_id",warden_id));
		warden.setWarden_id(wardenDto.getWarden_id());
		warden.setWarden_name(wardenDto.getWarden_name());
		warden.setWarden_contact(wardenDto.getWarden_contact());
		warden.setWarden_floor(wardenDto.getWarden_floor());
	
		this.wardenRepo.save(warden);
		return this.wardenToWardenDto(warden);
	}

	@Override
	public void deleteWardenById(int warden_id) {
	  Warden warden=this.wardenRepo.findById(warden_id).orElseThrow(
			  ()->new ResourceNotFoundException("warden","wardenId",warden_id));
		this.wardenRepo.delete(warden);
	}


	private WardenDto wardenToWardenDto(Warden warden) {
		WardenDto wardenDto = new WardenDto();
		wardenDto.setWarden_id(warden.getWarden_id());
		wardenDto.setWarden_name(warden.getWarden_name());
		wardenDto.setWarden_contact(warden.getWarden_contact());
		wardenDto.setWarden_floor(warden.getWarden_floor());

		return wardenDto;
	}

	private Warden wardenDtoToWarden(WardenDto wardenDto) {
		Warden warden = new Warden();
		warden.setWarden_id(wardenDto.getWarden_id());
		warden.setWarden_name(wardenDto.getWarden_name());
		warden.setWarden_contact(wardenDto.getWarden_contact());

		warden.setWarden_floor(wardenDto.getWarden_floor());

		return warden;
	}

}
