package sk.fiit;

import org.springframework.boot.logging.LogLevel;

import java.time.LocalDateTime;

public class Logger {
    private static Logger instance;
    private final LogLevel logLevel;

    private Logger() {
        logLevel = Config.LOG_LEVEL;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(Paradigm p, LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            String log = String.format("[%s] [%s] [%s] %s", p.toString(), level, LocalDateTime.now(), message);
            System.out.println(log);
        }
    }

    public void logOOP(LogLevel level, String message) {
        log(Paradigm.OOP, level, message);
    }

    public void logAOP(LogLevel level, String message) {
        log(Paradigm.AOP, level, message);
    }
}
