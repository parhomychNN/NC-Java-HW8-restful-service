package ru.parhomych.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.parhomych.restfulwebservice.model.Customer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class RestfulWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServiceApplication.class, args);
    }

}
