package com.example.lab01.mapper;

import com.example.lab01.dto.CourseDTO;
import com.example.lab01.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends EntityMapper<Course, CourseDTO> {
}
