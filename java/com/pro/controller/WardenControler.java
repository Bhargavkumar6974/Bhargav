package com.pro.controller;

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

import com.exceptions.ApiResponse;
import com.pro.payload.WardenDto;
import com.pro.service.WardenSer;


@RestController
@RequestMapping("/wardenMain")
public class WardenControler {

	

	@Autowired
	private WardenSer wardenSer;
    
	@PostMapping("/wardenCreate")
	public ResponseEntity<WardenDto> createWarden(@Valid @RequestBody WardenDto warden)
	{
		WardenDto createWarden=this.wardenSer.createWarden(warden);
		return new ResponseEntity<WardenDto>(createWarden,HttpStatus.CREATED);
	}
	
	@GetMapping("/wardenGet")
	public ResponseEntity<List<WardenDto>> getWardens()
	{
		List<WardenDto> allWardens=this.wardenSer.getWardens();
		return new ResponseEntity<List<WardenDto>>(allWardens,HttpStatus.OK);
	}
	
	@GetMapping("/warden/{warden_id}")
	public ResponseEntity<WardenDto> getWardenById(@PathVariable int warden_id)
	{
		WardenDto wardenDto=this.wardenSer.getWardenById(warden_id);
		return new ResponseEntity<WardenDto>(wardenDto,HttpStatus.OK);
	}
	
	@PutMapping("/wardenUpdate/{warden_id}")
	public ResponseEntity<WardenDto> updateWardenById(@RequestBody WardenDto warden,@PathVariable int warden_id)
	{
		WardenDto wardenDto=this.wardenSer.updateWardenById(warden, warden_id);
		return new ResponseEntity<WardenDto>(wardenDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/warden/{warden_id}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable int warden_id)
	{
		this.wardenSer.deleteWardenById(warden_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User record is deleted successfully",true),HttpStatus.OK);
		
	}
	
	
}



