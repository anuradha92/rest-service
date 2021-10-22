package com.anuradha.crud.configuration;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection() {
        return "DB connection for DEV";
    }

    @Profile("test")
    @Bean
    public String testDatabaseConnection() {
        return "DB Connection to TEST";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection() {
        return "DB Connection to PROD";
    }
}
