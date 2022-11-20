package ru.one.crud;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.one.crud.utils.HTTPClient;

@TestConfiguration
@SpringBootConfiguration
@ComponentScan("ru.one.crud")
public class TestConfig {

    @Bean
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }

    @Bean
    public HTTPClient httpClient() {
        return new HTTPClient();
    }

}
