package com.pro.service;


import java.util.List;

import com.pro.payload.WardenDto;

public interface WardenSer {

	public WardenDto createWarden(WardenDto wardenDto);

	void deleteWardenById(int warden_id);

	WardenDto updateWardenById(WardenDto wardenDto, int warden_id);

	WardenDto getWardenById(int warden_id);

	List<WardenDto> getWardens();
}
