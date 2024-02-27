package ru.example.http.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.example.LoggingProperties;

import java.io.BufferedInputStream;
import java.io.IOException;
@Slf4j
@RequiredArgsConstructor
//@Component
public class LoggingFilter implements Filter {
    private final LoggingProperties properties;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logRequest(httpServletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
        logResponse(httpServletRequest,  (HttpServletResponse) servletResponse);
    }
    private void logResponse(HttpServletRequest request, HttpServletResponse response) {
        log.info("request {}, response {}", request, response);
    }

    private void logRequest(HttpServletRequest servletRequest) throws IOException {
        if (properties.isLogBody()) {
            try (BufferedInputStream is = new BufferedInputStream(servletRequest.getInputStream())) {
                String body = new String(is.readAllBytes());
                log.info("request body: {}", body);
            }
        }
    }
}
