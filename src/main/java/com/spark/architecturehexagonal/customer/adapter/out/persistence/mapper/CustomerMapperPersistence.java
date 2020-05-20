package com.spark.architecturehexagonal.customer.adapter.out.persistence.mapper;

import com.spark.architecturehexagonal.customer.adapter.out.persistence.entity.CustomerEntity;
import com.spark.architecturehexagonal.customer.domain.Customer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(CustomerMapperPersistenceDecorator.class)
public interface CustomerMapperPersistence {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "document", target = "document")
    @Mapping(source = "uuid", target = "uuid")
    CustomerEntity toEntity(final Customer customer);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "document", target = "document")
    @Mapping(source = "uuid", target = "uuid")
    Customer toDomain(final CustomerEntity entity);
}
