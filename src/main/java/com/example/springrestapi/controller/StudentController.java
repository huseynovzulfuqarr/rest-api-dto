package com.example.springrestapi.controller;

import com.example.springrestapi.dto.StudentRequestDto;
import com.example.springrestapi.dto.StudentResponseDto;
import com.example.springrestapi.service.StudentResponseService;
import com.example.springrestapi.service.StudentResponseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentResponseServiceImpl studentResponseService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok( this.studentResponseService.getStudent(id));
    }

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto){
        return ResponseEntity.ok(this.studentResponseService.createStudent(studentRequestDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable("id") Long id,
                                                            @RequestBody StudentRequestDto studentRequestDto){
        return ResponseEntity.ok(this.studentResponseService.updateStudent(id,studentRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable("id") Long id){
        this.studentResponseService.delete(id);
    }
}
