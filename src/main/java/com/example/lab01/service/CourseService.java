package com.example.lab01.service;

import com.example.lab01.dto.CourseDTO;
import com.example.lab01.entity.Course;
import com.example.lab01.mapper.CourseMapper;
import com.example.lab01.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseDTO save(CourseDTO course) {
        Course entity = courseMapper.toEntity(course);
        entity.setIsActive(Boolean.TRUE);
        return courseMapper.toDTO(courseRepository.save(entity));
    }
}
