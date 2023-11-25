package com.example.lab01.controller;

import com.example.lab01.dto.CourseDTO;
import com.example.lab01.dto.ExternalDTO;
import com.example.lab01.exception.BussinessException;
import com.example.lab01.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getall")
    public ResponseEntity<List<CourseDTO>> getAll() {
        List<CourseDTO> result = courseService.getAll();
        return ResponseEntity.ok(result);

    }

    @GetMapping("/call-external")
    public ResponseEntity<ExternalDTO> callExternal() throws BussinessException {
        ExternalDTO result = courseService.cellExternal();
        return ResponseEntity.ok(result);

    }

}
