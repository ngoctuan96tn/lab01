package com.example.lab01.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseRegistryDTO extends ResponseDTO {
    @NotNull(message = "courseId is required")
    private Long courseId;
    @NotNull(message = "studentId is required")
    private Long studentId;
}
