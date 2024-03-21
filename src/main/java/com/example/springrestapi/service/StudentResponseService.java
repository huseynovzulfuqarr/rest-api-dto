package com.example.springrestapi.service;

import com.example.springrestapi.dto.StudentRequestDto;
import com.example.springrestapi.dto.StudentResponseDto;
import org.springframework.stereotype.Service;


public interface StudentResponseService {
    StudentResponseDto getStudent(Long id);
    StudentResponseDto createStudent(StudentRequestDto studentRequestDto);
    StudentResponseDto updateStudent(Long id,StudentRequestDto studentRequestDto );
    void delete(Long id);

}
