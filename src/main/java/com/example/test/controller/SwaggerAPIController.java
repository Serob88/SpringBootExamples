package com.example.test.controller;

import com.example.test.api.ProductApi;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/products")
public class SwaggerAPIController implements ProductApi {

  @Override
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<String>> getAll() {
    List<String> productsList = new ArrayList<>();
    productsList.add("Honey");
    productsList.add("Almond");
    return ResponseEntity.ok(productsList);
  }

  @RequestMapping(value = "/products", method = RequestMethod.POST)
  public String createProduct() {
    return "Product is saved successfully";
  }


}
