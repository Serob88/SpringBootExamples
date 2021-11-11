package com.example.test;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableScheduling
@EnableSwagger2
public class TestApplication {

  @Lazy
  private final EurekaClient eurekaClient;

  public TestApplication(@Qualifier("eurekaClient") EurekaClient eurekaClient) {
    this.eurekaClient = eurekaClient;
  }

  public static void main(String[] args) {
    SpringApplication.run(TestApplication.class, args);
  }

//  @Bean
//  public Docket productApi() {
//    return new Docket(DocumentationType.SWAGGER_2).select()
//        .apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo")).build();
//  }

  @RequestMapping(value = "/actuator/info")
  public String hello() {
    return "Hello World from TestApplication Class";
  }

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
