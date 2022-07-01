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
import com.pro.payload.AdminDto;
import com.pro.service.AdminSer;

@RestController
@RequestMapping("/adminMain")
public class AdminControler
{
	@Autowired
	private AdminSer adminSer;
    
	@PostMapping("/adminCreate")
	public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminDto admin)
	{
		AdminDto createAdmin=this.adminSer.createAdmin(admin);
		return new ResponseEntity<AdminDto>(createAdmin,HttpStatus.CREATED);
	}
	
	@GetMapping("/adminGet")
	public ResponseEntity<List<AdminDto>> getAdmins()
	{
		List<AdminDto> allAdmins=this.adminSer.getAdmins();
		return new ResponseEntity<List<AdminDto>>(allAdmins,HttpStatus.OK);
	}
	
	@GetMapping("/admin/{admin_id}")
	public ResponseEntity<AdminDto> getAdminById(@PathVariable int admin_id)
	{
		AdminDto adminDto=this.adminSer.getAdminById(admin_id);
		return new ResponseEntity<AdminDto>(adminDto,HttpStatus.OK);
	}
	
	@PutMapping("/adminUpdate/{admin_id}")
	public ResponseEntity<AdminDto> updateAdminById(@RequestBody AdminDto admin,@PathVariable int admin_id)
	{
		AdminDto adminDto=this.adminSer.updateAdminById(admin, admin_id);
		return new ResponseEntity<AdminDto>(adminDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/{admin_id}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable int admin_id)
	{
		this.adminSer.deleteAdminById(admin_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User record is deleted successfully",true),HttpStatus.OK);
		
	}
	
	
}