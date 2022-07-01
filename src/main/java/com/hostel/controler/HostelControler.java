package com.hostel.controler;

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

import com.hostel.exceptions.ApiResponse;
import com.hostel.payload.HostelDto;
import com.hostel.service.HostelSer;


@RestController
@RequestMapping("/api")
public class HostelControler
{
	@Autowired
	private HostelSer hostelSer;
    
	@PostMapping("/hostelCreate")
	public ResponseEntity<HostelDto> createHostel(@Valid @RequestBody HostelDto hostel)
	{
		HostelDto createHostel=this.hostelSer.createHostel(hostel);
		return new ResponseEntity<HostelDto>(createHostel,HttpStatus.CREATED);
	}
	
	@GetMapping("/hostelGet")
	public ResponseEntity<List<HostelDto>> getHostels()
	{
		List<HostelDto> allHostels=this.hostelSer.getHostels();
		return new ResponseEntity<List<HostelDto>>(allHostels,HttpStatus.OK);
	}
	
	@GetMapping("/hostel/{hostel_id}")
	public ResponseEntity<HostelDto> getHostelById(@PathVariable int hostel_id)
	{
		HostelDto hostelDto=this.hostelSer.getHostelById(hostel_id);
		return new ResponseEntity<HostelDto>(hostelDto,HttpStatus.OK);
	}
	
	@PutMapping("/hostelUpdate/{hostel_id}")
	public ResponseEntity<HostelDto> updateHostelById(@RequestBody HostelDto hostel,@PathVariable int hostel_id)
	{
		HostelDto hostelDto=this.hostelSer.updateHostelById(hostel, hostel_id);
		return new ResponseEntity<HostelDto>(hostelDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/hostel/{hostel_id}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable int hostel_id)
	{
		this.hostelSer.deleteHostelById(hostel_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User record is deleted successfully",true),HttpStatus.OK);
		
	}
	
	
}