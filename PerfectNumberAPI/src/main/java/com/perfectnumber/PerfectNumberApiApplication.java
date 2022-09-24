package com.perfectnumber;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Perfect Number API", version = "1.0", description = "Perfect Number Computation"))
public class PerfectNumberApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfectNumberApiApplication.class, args);
    }

}
