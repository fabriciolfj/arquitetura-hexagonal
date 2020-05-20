package com.spark.architecturehexagonal.customer.application.port.out.mapper;

import com.spark.architecturehexagonal.customer.application.port.out.dto.AddressResponseDto;
import com.spark.architecturehexagonal.customer.application.port.out.dto.CustomerResponseDto;
import com.spark.architecturehexagonal.customer.domain.Customer;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@NoArgsConstructor
public abstract class CustomerResponseMapperDecorator implements CustomerResponseMapper {

    @Autowired
    private CustomerResponseMapper mapper;

    @Override
    public CustomerResponseDto toDto(final Customer customer) {
        var dto = mapper.toDto(customer);
        dto.setAddress(customer
                .getAddresses()
                .stream()
                .map(address ->
                        AddressResponseDto
                                .builder()
                                .describe(address.getDescribe())
                                .build())
                .collect(Collectors.toList()));
        return dto;
    }
}
