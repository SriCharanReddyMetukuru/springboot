package com.wipro.springboot.usecase1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeUseCase1Application {

    private static final Logger log = LoggerFactory.getLogger(EmployeeUseCase1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeUseCase1Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            // Save a few employees with different values
            repository.save(new Employee("Charan", "Developer"));
            repository.save(new Employee("Reddy", "Tester"));
            repository.save(new Employee("Rahul", "Architect"));
            repository.save(new Employee("Megha", "Tester"));
            repository.save(new Employee("Sara", "Developer"));

            // Fetch all employees
            log.info("Employees found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(employee -> {
                log.info(employee.toString());
            });
            log.info("");

            // Fetch an individual employee by ID
            Employee employee = repository.findById(2L);
            log.info("Employee found with findById(2L):");
            log.info("--------------------------------");
            log.info(employee.toString());
            log.info("");

            // Fetch employees by role
            log.info("Employees found with findByRole('Developer'):");
            log.info("---------------------------------------------");
            repository.findByRole("Developer").forEach(dev -> {
                log.info(dev.toString());
            });
            log.info("");
        };
    }
}