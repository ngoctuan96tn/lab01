package com.example.lab01.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:web.properties")
@Data
public class WebProperties {
    @Value("${apiUrl}")
    private String apiUrl;
}
