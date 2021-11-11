package com.example.test.api;

import com.example.test.pojo.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Api(tags = "Product")
public
interface ProductApi extends BaseApi {

  @ApiOperation(value = "Get all products")
  @ApiResponses({
      @ApiResponse(code = 200, message = "OK", response = Product.class)
  })
  ResponseEntity<List<String>> getAll();
}
