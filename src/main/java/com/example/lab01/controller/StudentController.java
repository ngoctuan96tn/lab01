package com.example.lab01.controller;

import com.example.lab01.dto.StudentDTO;
import com.example.lab01.entity.Student;
import com.example.lab01.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO student) {
        StudentDTO result = studentService.save(student);
        return ResponseEntity.ok(result);

    }

}
