package com.spark.architecturehexagonal.customer.application.port.in.mapper;

import com.spark.architecturehexagonal.customer.application.port.in.dto.CustomerRequestDto;
import com.spark.architecturehexagonal.customer.domain.Customer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(CustomerRequestMapperDecorator.class)
public interface CustomerRequestMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "document", target = "document")
    Customer toDomain(final CustomerRequestDto dto);

}
