package com.example.lab01.controller;

import com.example.lab01.dto.CourseRegistryDTO;
import com.example.lab01.dto.StudentDTO;
import com.example.lab01.exception.BussinessException;
import com.example.lab01.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

    @PostMapping("/registry-course")
    public ResponseEntity<CourseRegistryDTO> registryCourse(@RequestBody CourseRegistryDTO dto) throws BussinessException {
        CourseRegistryDTO result = studentService.registryCourse(dto);
        if (Objects.isNull(result) || Objects.isNull(result.getStudentId()) || Objects.isNull(result.getCourseId())) {
            result.setErrorCode("11");
            result.setMessage("Đăng ký không thành công.");
        } else {
            result.setErrorCode("9");
            result.setMessage("Đăng ký thành công.");
        }
        return ResponseEntity.ok(result);

    }

}
