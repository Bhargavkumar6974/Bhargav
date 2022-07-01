package com.hostel.service;

import java.util.List;

import com.hostel.payload.AdminDto;

public interface AdminSer {

	public AdminDto createAdmin(AdminDto adminDto);

	void deleteAdminById(int admin_id);

	AdminDto updateAdminById(AdminDto adminDto, int admin_id);

	AdminDto getAdminById(int admin_id);

	List<AdminDto> getAdmins();
}
