package com.pro.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptions.ResourceNotFoundException;
import com.pro.entity.Floor;
import com.pro.entity.Student;
import com.pro.payload.FloorDto;
import com.pro.payload.StudentDto;
import com.pro.repo.FloorRepo;
import com.pro.service.FloorSer;

@Service
public class FloorImp implements FloorSer {

	@Autowired

	private FloorRepo floorRepo;

	@Override
	public FloorDto createFloor(FloorDto floorDto) {
		Floor floor = this.floorDtoToFloor(floorDto);
		Floor saveFloor = this.floorRepo.save(floor);
		return this.floorToFloorDto(saveFloor);
	}

	@Override
	public List<FloorDto> getFloors() {
		List<Floor> floorRecordsEntity = this.floorRepo.findAll();
		List<FloorDto> floorRecordsDto = floorRecordsEntity.stream().map(floor1 -> this.floorToFloorDto(floor1)).collect(Collectors.toList());
		return floorRecordsDto;

	}

	@Override
	public FloorDto getFloorById(int floor_id) {
		Floor floor=this.floorRepo.findById(floor_id).orElseThrow(
				()->new ResourceNotFoundException("floor","floorId",floor_id));
		return this.floorToFloorDto(floor); //dto for fetching
	}

	@Override
	public FloorDto updateFloorById(FloorDto floorDto, int floor_id) {
		Floor floor=this.floorRepo.findById(floor_id).orElseThrow(()-> new ResourceNotFoundException("floor","Floor_id",floor_id));
		floor.setFloor_id(floorDto.getFloor_id());
		floor.setHostel_id(floorDto.getHostel_id());
		floor.setWarden_id(floorDto.getWarden_id());
		floor.setNo_of_rooms(floorDto.getNo_of_rooms());
		floor.setNo_of_students(floorDto.getNo_of_students());
		this.floorRepo.save(floor);
		return this.floorToFloorDto(floor);
	}

	@Override
	public void deleteFloorById(int floor_id) {
	  Floor floor=this.floorRepo.findById(floor_id).orElseThrow(
			  ()->new ResourceNotFoundException("floor","floorId",floor_id));
		this.floorRepo.delete(floor);
	}


	
	private FloorDto floorToFloorDto(Floor floor) {
		FloorDto floorDto = new FloorDto();
		floor.setFloor_id(floor.getFloor_id());
		floor.setHostel_id(floor.getHostel_id());
		floor.setWarden_id(floor.getWarden_id());
		floor.setNo_of_students(floor.getNo_of_students());
		floor.setNo_of_rooms(floor.getNo_of_rooms());

		return floorDto;
	}

	private Floor floorDtoToFloor(FloorDto floorDto) {
			
			Floor floor = new Floor();
			floor.setFloor_id(floorDto.getFloor_id());
			floor.setHostel_id(floorDto.getHostel_id());
			floor.setWarden_id(floorDto.getWarden_id());
			floor.setNo_of_students(floorDto.getNo_of_students());
			floor.setNo_of_rooms(floorDto.getNo_of_rooms());

		return floor;
	
	}

}