package sk.fiit;

import org.springframework.boot.logging.LogLevel;

public class Main {
    private static final Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        System.out.println(
                "Hello and welcome!\n" +
                        "I want to log something important, when calling important method."
        );

        int num = 42;

        // OOP - logging calling of important method
        logger.logOOP(LogLevel.INFO, "Method 'importantMethodOOP' will be called with input: " + num);
        importantMethodOOP(num);
        logger.logOOP(LogLevel.INFO, "Method 'importantMethodOOP' was called.");

        // AOP - logging calling of important method
        importantMethodAOP(42);
    }

    private static void importantMethodOOP(int importantNum) {
        logger.logOOP(LogLevel.INFO, "Method 'importantMethodOOP' is called with input: " + importantNum);
        System.out.println("Hello from 'importantMethodOOP' with input: " + importantNum);
    }

    @LOG(level = LogLevel.INFO)
    private static void importantMethodAOP(int importantNum) {
        System.out.println("Hello from 'importantMethodAOP' with input: " + importantNum);
    }
}
