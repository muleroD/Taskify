package br.com.mulero.taskify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class TaskifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskifyApplication.class, args);
    }

}
