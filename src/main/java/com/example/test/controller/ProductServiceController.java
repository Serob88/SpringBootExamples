package com.example.test.controller;

import com.example.test.annotaion.OptionalEndpoint;
import com.example.test.pojo.Product;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

  @Autowired
  ProductService productService;

  @OptionalEndpoint(property = "test.enable")
  @RequestMapping(value = "/Sproducts", method = RequestMethod.GET)
  public ResponseEntity<Object> getProduct() {
    return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
  }
  @RequestMapping(value = "/Sproducts/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Object>
  updateProduct(@PathVariable("id") String id, @RequestBody Product product) {

    productService.updateProduct(id, product);
    return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
  }
  @RequestMapping(value = "/Sproducts/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> delete(@PathVariable("id") String id) {
    productService.deleteProduct(id);
    return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
  }
  @RequestMapping(value = "/Sproducts", method = RequestMethod.POST)
  public ResponseEntity<Object> createProduct(@RequestBody Product product) {
    productService.createProduct(product);
    return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
  }
}
