package com.example.lab01.service;

import com.example.lab01.config.WebProperties;
import com.example.lab01.dto.CourseDTO;
import com.example.lab01.dto.ExternalDTO;
import com.example.lab01.entity.Course;
import com.example.lab01.exception.BussinessException;
import com.example.lab01.mapper.CourseMapper;
import com.example.lab01.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final WebProperties webProperties;

    public CourseDTO save(CourseDTO course) {
        Course entity = courseMapper.toEntity(course);
        entity.setIsActive(Boolean.TRUE);
        return courseMapper.toDTO(courseRepository.save(entity));
    }

    public List<CourseDTO> getAll() {
        return courseMapper.toDTO(courseRepository.findByIsActive(Boolean.TRUE));

    }

    public ExternalDTO cellExternal() throws BussinessException {
        Map<String, ExternalDTO> map = new HashMap<>();

        WebClient webClient = WebClient.create();

        // Replace the URL with the actual API endpoint
        String apiUrl = webProperties.getApiUrl();

        Mono<ExternalDTO> mono = webClient.get()
                    .uri(apiUrl)
                    .retrieve()
                    .bodyToMono(ExternalDTO.class);
        if (mono == null) {
            throw new BussinessException("Không lấy được thông tin API!");
        }

        return mono.block();
    }

}
