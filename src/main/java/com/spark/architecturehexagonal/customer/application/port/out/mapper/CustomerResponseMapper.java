package com.spark.architecturehexagonal.customer.application.port.out.mapper;

import com.spark.architecturehexagonal.customer.application.port.out.dto.CustomerResponseDto;
import com.spark.architecturehexagonal.customer.domain.Customer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(CustomerResponseMapperDecorator.class)
public interface CustomerResponseMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "uuid", target = "uuid")
    CustomerResponseDto toDto(final Customer customer);
}

