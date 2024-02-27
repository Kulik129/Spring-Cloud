package ru.example;

import lombok.Data;
import org.apache.logging.log4j.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties("http.logging")
public class LoggingProperties {
    /**
     * Включить/выключить тело запроса.
     */
    private boolean logBody;
    /**
     * Уровень логирования.
     */
    private Level logLevel = Level.DEBUG;
}
