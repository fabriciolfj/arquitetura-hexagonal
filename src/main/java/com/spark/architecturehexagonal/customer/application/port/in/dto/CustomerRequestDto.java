package com.spark.architecturehexagonal.customer.application.port.in.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CustomerRequestDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String document;
    @NotEmpty
    private String address;
}
