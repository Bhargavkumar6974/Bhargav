
package com.hostel.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.entity.StudentEntity;
import com.hostel.entity.WardenEntity;
import com.hostel.exceptions.ResourceNotFoundException;
import com.hostel.payload.StudentDto;
import com.hostel.payload.WardenDto;
import com.hostel.repo.WardenRepository;
import com.hostel.service.WardenSer;

@Service
public class WardenImp implements WardenSer {

	@Autowired

	private WardenRepository wardenRepo;

	@Override
	public WardenDto createWarden(WardenDto wardenDto) {
		WardenEntity warden = this.wardenDtoToWarden(wardenDto);
		WardenEntity saveWarden = this.wardenRepo.save(warden);
		return this.wardenToWardenDto(saveWarden);
	}

	
	
	@Override
	public List<WardenDto> getWardens() {
		List<WardenEntity> wardenRecordsEntity = this.wardenRepo.findAll();
		List<WardenDto> wardenRecordsDto = wardenRecordsEntity.stream().map(warden1 -> this.wardenToWardenDto(warden1))
				.collect(Collectors.toList());
		return wardenRecordsDto;

	}

	@Override
	public WardenDto getWardenById(int warden_id) {
		WardenEntity warden=this.wardenRepo.findById(warden_id).orElseThrow(
				()->new ResourceNotFoundException("warden","wardenId",warden_id));
		return this.wardenToWardenDto(warden); //dto for fetching
	}

	@Override
	public WardenDto updateWardenById(WardenDto wardenDto, int warden_id) {
		WardenEntity warden=this.wardenRepo.findById(warden_id).orElseThrow(()-> new ResourceNotFoundException("warden","Warden_id",warden_id));
		warden.setWarden_id(wardenDto.getWarden_id());
		warden.setWarden_name(wardenDto.getWarden_name());
		warden.setWarden_contact(wardenDto.getWarden_contact());
		warden.setWarden_floor(wardenDto.getWarden_floor());
	
		this.wardenRepo.save(warden);
		return this.wardenToWardenDto(warden);
	}

	@Override
	public void deleteWardenById(int warden_id) {
	  WardenEntity warden=this.wardenRepo.findById(warden_id).orElseThrow(
			  ()->new ResourceNotFoundException("warden","wardenId",warden_id));
		this.wardenRepo.delete(warden);
	}


	private WardenDto wardenToWardenDto(WardenEntity warden) {
		WardenDto wardenDto = new WardenDto();
		wardenDto.setWarden_id(warden.getWarden_id());
		wardenDto.setWarden_name(warden.getWarden_name());
		wardenDto.setWarden_contact(warden.getWarden_contact());
		wardenDto.setWarden_floor(warden.getWarden_floor());

		return wardenDto;
	}

	private WardenEntity wardenDtoToWarden(WardenDto wardenDto) {
		WardenEntity warden = new WardenEntity();
		warden.setWarden_id(wardenDto.getWarden_id());
		warden.setWarden_name(wardenDto.getWarden_name());
		warden.setWarden_contact(wardenDto.getWarden_contact());

		warden.setWarden_floor(wardenDto.getWarden_floor());

		return warden;
	}

}
