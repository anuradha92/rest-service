package com.test.sampleProject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CrudOperationApplication {

    public static void main(String[] args) {
        log.info("Executing CrudOperationApplication");
        SpringApplication.run(CrudOperationApplication.class, args);
    }

}
