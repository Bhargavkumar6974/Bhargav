package com.pro.service;

import java.util.List;

import com.pro.payload.HostelDto;

public interface HostelSer {

	public HostelDto createHostel(HostelDto hostelDto);

	void deleteHostelById(int hostel_id);

	HostelDto updateHostelById(HostelDto hostelDto, int hostel_id);

	HostelDto getHostelById(int hostel_id);

	List<HostelDto> getHostels();
}
