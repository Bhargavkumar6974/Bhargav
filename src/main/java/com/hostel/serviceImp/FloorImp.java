package com.hostel.serviceImp;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.entity.FloorEntity;
import com.hostel.entity.StudentEntity;
import com.hostel.exceptions.ResourceNotFoundException;
import com.hostel.payload.FloorDto;
import com.hostel.payload.StudentDto;
import com.hostel.repo.FloorRepository;
import com.hostel.service.FloorSer;

@Service
public class FloorImp implements FloorSer {

	@Autowired

	private FloorRepository floorRepo;

	@Override
	public FloorDto createFloor(FloorDto floorDto) {
		FloorEntity floor = this.floorDtoToFloor(floorDto);
		FloorEntity saveFloor = this.floorRepo.save(floor);
		return this.floorToFloorDto(saveFloor);
	}

	@Override
	public List<FloorDto> getFloors() {
		List<FloorEntity> floorRecordsEntity = this.floorRepo.findAll();
		List<FloorDto> floorRecordsDto = floorRecordsEntity.stream().map(floor1 -> this.floorToFloorDto(floor1)).collect(Collectors.toList());
		return floorRecordsDto;

	}

	@Override
	public FloorDto getFloorById(int floor_id) {
		FloorEntity floor=this.floorRepo.findById(floor_id).orElseThrow(
				()->new ResourceNotFoundException("floor","floorId",floor_id));
		return this.floorToFloorDto(floor); //dto for fetching
	}

	@Override
	public FloorDto updateFloorById(FloorDto floorDto, int floor_id) {
		FloorEntity floor=this.floorRepo.findById(floor_id).orElseThrow(()-> new ResourceNotFoundException("floor","Floor_id",floor_id));
		floor.setFloor_id(floorDto.getFloor_id());
		floor.setHostel_id(floorDto.getHostel_id());
		floor.setWarden_id(floorDto.getWarden_id());
		floor.setNo_of_rooms(floorDto.getNo_of_rooms());
		//floor.setNo_of_students(floorDto.getNo_of_students());
		this.floorRepo.save(floor);
		return this.floorToFloorDto(floor);
	}

	@Override
	public void deleteFloorById(int floor_id) {
	  FloorEntity floor=this.floorRepo.findById(floor_id).orElseThrow(
			  ()->new ResourceNotFoundException("floor","floorId",floor_id));
		this.floorRepo.delete(floor);
	}


	
	private FloorDto floorToFloorDto(FloorEntity floor) {
		FloorDto floorDto = new FloorDto();
		floorDto.setFloor_id(floor.getFloor_id());
		floorDto.setHostel_id(floor.getHostel_id());
		floorDto.setWarden_id(floor.getWarden_id());
		//floorDto.setNo_of_students(floor.getNo_of_students());
		floorDto.setNo_of_rooms(floor.getNo_of_rooms());

		return floorDto;
	}

	private FloorEntity floorDtoToFloor(FloorDto floorDto) {
			
			FloorEntity floor = new FloorEntity();
			floor.setFloor_id(floorDto.getFloor_id());
			floor.setHostel_id(floorDto.getHostel_id());
			floor.setWarden_id(floorDto.getWarden_id());
		//	floor.setNo_of_students(floorDto.getNo_of_students());
			floor.setNo_of_rooms(floorDto.getNo_of_rooms());

		return floor;
	
	}

}