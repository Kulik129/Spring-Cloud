package ru.example;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example.http.logging.LoggingFilter;

@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
public class HttpLoggingConfiguration {
    @Bean
    LoggingFilter loggingFilter(LoggingProperties properties) {
        return new LoggingFilter(properties);
    }
}
