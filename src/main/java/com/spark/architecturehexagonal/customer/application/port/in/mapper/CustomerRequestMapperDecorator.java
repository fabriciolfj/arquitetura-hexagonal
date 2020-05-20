package com.spark.architecturehexagonal.customer.application.port.in.mapper;

import com.spark.architecturehexagonal.customer.application.port.in.dto.CustomerRequestDto;
import com.spark.architecturehexagonal.customer.domain.Address;
import com.spark.architecturehexagonal.customer.domain.Customer;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@NoArgsConstructor
public abstract class CustomerRequestMapperDecorator implements CustomerRequestMapper {

    @Autowired
    private CustomerRequestMapper mapper;

    @Override
    public Customer toDomain(final CustomerRequestDto dto) {
        var customer = mapper.toDomain(dto);
        var address = Address.builder()
                .describe(dto.getAddress())
                .build();
        customer.setAddresses(Arrays.asList(address));
        return customer;
    }
}
