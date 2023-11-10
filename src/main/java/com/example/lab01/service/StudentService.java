package com.example.lab01.service;

import com.example.lab01.dto.StudentDTO;
import com.example.lab01.entity.Student;
import com.example.lab01.mapper.StudentMapper;
import com.example.lab01.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentDTO save(StudentDTO student) {
        student.setIsActive(Boolean.TRUE);
        Student entity = studentMapper.toEntity(student);
        return studentMapper.toDTO(studentRepository.save(entity));
    }
}
