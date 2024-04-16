package com.example.JeepCodesAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JeepCodesAPI.model.JeepCode;

public interface JeepCodeRepository extends JpaRepository<JeepCode, String>{
    
}
