package com.spark.architecturehexagonal.customer.application.port.out.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerResponseDto {

    private String uuid;
    private String name;
    private List<AddressResponseDto> address;
}
