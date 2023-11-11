package com.example.lab01.controller;

import com.example.lab01.dto.CourseDTO;
import com.example.lab01.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    @PostMapping("/create")
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO course) {
        CourseDTO result = courseService.save(course);
        return ResponseEntity.ok(result);

    }

}
