package com.example.springrestapi.service;

import com.example.springrestapi.dto.StudentRequestDto;
import com.example.springrestapi.dto.StudentResponseDto;
import com.example.springrestapi.exception.StudentNotFoundException;
import com.example.springrestapi.model.Student;
import com.example.springrestapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentResponseServiceImpl implements  StudentResponseService{

    private final StudentRepository studentRepository;

    @Override
    public StudentResponseDto getStudent(Long id) {
        log.trace("STUDENT GET BY ID");
       final Student student=this.studentRepository.findById(id).
                orElseThrow(StudentNotFoundException::new);
       StudentResponseDto studentResponseDto=StudentResponseDto.builder()
               .id(student.getId())
               .firstName(student.getFirstName())
               .lastName(student.getLastName())
               .email(student.getEmail())
               .build();
       return studentResponseDto;
    }

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        log.trace("CREATE STUDENT");
        Student student=Student.builder()
                .firstName(studentRequestDto.getFirstName())
                .lastName(studentRequestDto.getLastName())
                .email(studentRequestDto.getEmail())
                .build();
        final Student student1=this.studentRepository.save(student);
        StudentResponseDto studentResponseDto=StudentResponseDto.builder()
                .id(student1.getId())
                .firstName(student1.getFirstName())
                .lastName(student1.getLastName())
                .email(student1.getEmail())
                .build();
        return studentResponseDto;

    }

    @Override
    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) {
        log.trace("STUDENT UPDATE");
       final Student student=this.studentRepository.findById(id)
               .orElseThrow(StudentNotFoundException::new);
       student.setFirstName(studentRequestDto.getFirstName());
       student.setLastName(studentRequestDto.getLastName());
       student.setEmail(studentRequestDto.getEmail());

       final Student student1=this.studentRepository.save(student);

       StudentResponseDto studentResponseDto=StudentResponseDto.builder()
               .id(student1.getId())
               .firstName(student1.getFirstName())
               .lastName(student1.getLastName())
               .build();
       return studentResponseDto;
    }

    @Override
    public void delete(Long id) {
        log.trace("STUDENT DELETE BY ID");
        this.studentRepository.deleteById(id);

    }
}
