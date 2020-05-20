package com.spark.architecturehexagonal.customer.application.port.out.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressResponseDto {

    private String describe;
}
