package com.pro.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.exceptions.ApiResponse;
import com.pro.payload.FloorDto;
import com.pro.service.FloorSer;

@RestController
@RequestMapping("/api")
public class FloorControler {



@Autowired
private FloorSer floorSer;

@PostMapping("/floorCreate")
public ResponseEntity<FloorDto> createFloor(@Valid @RequestBody FloorDto floor)
{
	FloorDto createFloor=this.floorSer.createFloor(floor);
	return new ResponseEntity<FloorDto>(createFloor,HttpStatus.CREATED);
}

@GetMapping("/floorGet")
public ResponseEntity<List<FloorDto>> getFloors()
{
	List<FloorDto> allFloors=this.floorSer.getFloors();
	return new ResponseEntity<List<FloorDto>>(allFloors,HttpStatus.OK);
}

@GetMapping("/floor/{floor_id}")
public ResponseEntity<FloorDto> getFloorById(@PathVariable int floor_id)
{
	FloorDto floorDto=this.floorSer.getFloorById(floor_id);
	return new ResponseEntity<FloorDto>(floorDto,HttpStatus.OK);
}

@PutMapping("/floorUpdate/{floor_id}")
public ResponseEntity<FloorDto> updateFloorById(@RequestBody FloorDto floor,@PathVariable int floor_id)
{
	FloorDto floorDto=this.floorSer.updateFloorById(floor, floor_id);
	return new ResponseEntity<FloorDto>(floorDto,HttpStatus.OK);
}

@DeleteMapping("/floor/{floor_id}")
public ResponseEntity<ApiResponse> deleteUserById(@PathVariable int floor_id)
{
	this.floorSer.deleteFloorById(floor_id);
	return new ResponseEntity<ApiResponse>(new ApiResponse("User record is deleted successfully",true),HttpStatus.OK);
	
}


}