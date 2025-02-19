package com.donerhome;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for starting the DonerHome Spring Boot application.
 *
 * <p>
 * This class contains the main method, which serves as the entry point for the application.
 * It uses Spring Boot's {@link SpringApplication} to bootstrap the application.
 * </p>
 */
@SpringBootApplication
public class Main {

    // Logger for logging application startup events
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Main method for starting the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        logger.info("Starting DonerHome application"); // Log application start
        SpringApplication.run(Main.class, args);
        logger.info("DonerHome application started successfully"); // Log successful startup
    }

}
