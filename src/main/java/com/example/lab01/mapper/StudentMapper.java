package com.example.lab01.mapper;

import com.example.lab01.dto.StudentDTO;
import com.example.lab01.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<Student, StudentDTO> {
}
