package com.ITAcademy.simplehttpservice.repository;


import com.ITAcademy.simplehttpservice.dto.ResponseDto;

public interface IRepository {

    public ResponseDto getUser(String uuid);
}