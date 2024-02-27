package com.example;

import com.example.http.timer.TimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeConfiguration {
    @Bean
    TimeAspect timeAspect() {
        return new TimeAspect();
    }
}
