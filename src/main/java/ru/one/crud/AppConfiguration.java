package ru.one.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("ru.one.crud")
public class AppConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
