package com.ITAcademy.simplehttpservice.service;

import com.ITAcademy.simplehttpservice.dto.UserResponseDto;

public interface IUserService{
	UserResponseDto getUser(String uuid);
}