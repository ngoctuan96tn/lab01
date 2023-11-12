package com.example.lab01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private Boolean gender;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDay;
    private String address;
    private Boolean isActive;
}
