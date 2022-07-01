package com.hostel.service;

import java.util.List;

import com.hostel.payload.FloorDto;

public interface FloorSer {

	public FloorDto createFloor(FloorDto floorDto);

	void deleteFloorById(int floor_id);

	FloorDto updateFloorById(FloorDto floorDto, int floor_id);

	FloorDto getFloorById(int floor_id);

	List<FloorDto> getFloors();
}
