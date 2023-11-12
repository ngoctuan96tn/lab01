package com.example.lab01.service;

import com.example.lab01.dto.CourseRegistryDTO;
import com.example.lab01.dto.StudentDTO;
import com.example.lab01.entity.Course;
import com.example.lab01.entity.Student;
import com.example.lab01.exception.BussinessException;
import com.example.lab01.mapper.StudentMapper;
import com.example.lab01.repository.CourseRepository;
import com.example.lab01.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;

    public StudentDTO save(StudentDTO student) {
        Student entity = studentMapper.toEntity(student);
        entity.setIsActive(Boolean.TRUE);
        return studentMapper.toDTO(studentRepository.save(entity));
    }

    public CourseRegistryDTO registryCourse(CourseRegistryDTO dto) throws BussinessException {
        if (Objects.isNull(dto)) {
            throw new BussinessException("dto is required");
        }
        if (Objects.isNull(dto.getStudentId()) || Objects.isNull(dto.getCourseId())) {
            throw new BussinessException("courseID or studentID is required");
        }
        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        if (Objects.isNull(student)) {
            throw new BussinessException("student not found with id: " + dto.getStudentId());
        }
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (Objects.isNull(course)) {
            throw new BussinessException("course not found with id: " + dto.getCourseId());
        }
        int quantity = Objects.isNull(course.getQuantity()) ? 0 : course.getQuantity();
        if (quantity == 0) {
            throw new BussinessException("course [" + course.getName() + "] is full.");
        }

        Set<Student> students = course.getStudents();
        // check trùng đăng ký.
        boolean flag = students.add(student);
        if (flag == false) {
            throw new BussinessException(student.getName() + " is registered.");
        }

        course.setStudents(students);
        course.setQuantity(quantity - 1);
        Course saveCourse = courseRepository.save(course);
        CourseRegistryDTO result = new CourseRegistryDTO();
        result.setCourseId(saveCourse.getId());
        result.setStudentId(dto.getStudentId());
        return result;
    }
}
