package com.spark.architecturehexagonal.customer.application.port.in.mapper;

import com.spark.architecturehexagonal.customer.application.port.in.dto.CustomerRequestDto;
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
public class CustomerRequestMapperImpl_ implements CustomerRequestMapper {

    @Override
    public Customer toDomain(CustomerRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( dto.getName() );
        customer.setDocument( dto.getDocument() );

        return customer;
    }
}
