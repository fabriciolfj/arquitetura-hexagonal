package com.spark.architecturehexagonal.customer.application.port.out.mapper;

import com.spark.architecturehexagonal.customer.application.port.out.dto.CustomerResponseDto;
import com.spark.architecturehexagonal.customer.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-19T23:42:31-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Private Build)"
)
@Component
@Qualifier("delegate")
public class CustomerResponseMapperImpl_ implements CustomerResponseMapper {

    @Override
    public CustomerResponseDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setName( customer.getName() );
        customerResponseDto.setUuid( customer.getUuid() );

        return customerResponseDto;
    }
}
