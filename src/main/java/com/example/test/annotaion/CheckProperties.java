package com.example.test.annotaion;

import com.example.test.controller.ProductExceptionController;
import com.example.test.controller.ProductExceptionController.AOPException;
import java.lang.reflect.Method;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
@Profile("!test")
@Slf4j
public class CheckProperties {

  private final Environment environment;

  @Around("@annotation(com.example.test.annotaion.OptionalEndpoint)")
  public Object a(ProceedingJoinPoint call) throws Throwable {
    MethodSignature signature = (MethodSignature) call.getSignature();
    Method method = signature.getMethod();

    OptionalEndpoint myAnnotation = method.getAnnotation(OptionalEndpoint.class);
    String property = myAnnotation.property();

    if (environment.getProperty(property) == null || !Boolean.parseBoolean(environment.getProperty(property))) {
      throw new AOPException();
    } else {
      return call.proceed();
    }
  }
}
