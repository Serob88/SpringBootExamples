package com.example.test.api;


import com.example.test.SuccessResponseDto;
import org.springframework.http.ResponseEntity;

public interface BaseApi {

  default ResponseEntity<SuccessResponseDto> successResponseOk() {
    return ResponseEntity.ok(
        SuccessResponseDto.builder()
            .successCode("OK")
            .build()
    );
  }

  default <T> ResponseEntity<SuccessResponseDto> successResponseOk(T body) {
    return ResponseEntity.ok(
        SuccessResponseDto.builder()
            .successCode("OK")
            .content(body)
            .build()
    );
  }

}
