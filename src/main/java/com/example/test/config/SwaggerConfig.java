package com.example.test.config;

import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicates;
import java.time.Instant;
import java.time.LocalDateTime;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.Errors;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", value = "enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig {

  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";

  @Bean
  public Docket productApi() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .useDefaultResponseMessages(false)
        .select().apis(RequestHandlerSelectors.basePackage("com.swifttech.sp")).paths(Predicates.not(regex("/error")))
        .build()
        .ignoredParameterTypes(Errors.class, Sort.class, Pageable.class, Page.class, ApiIgnore.class)
        .directModelSubstitute(LocalDateTime.class, String.class)
        .useDefaultResponseMessages(false)
        .directModelSubstitute(Instant.class, String.class)
        .forCodeGeneration(true);

    docket = docket.select()
        .paths(regex(DEFAULT_INCLUDE_PATTERN))
        .build();

    return docket;
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("swiftech.am")
        .description("Spring Boot Example API")
        .contact(new Contact("Example",
            "https://www.test@.mail", "no-reply@test.am"))
        .build();
  }
}
