package com.example.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("SuccessResponseDto")
public class SuccessResponseDto<T> {

  @ApiModelProperty(value = "Success code", required = true)
  private String successCode;

  @ApiModelProperty(value = "Content of the response")
  private T content;

}
