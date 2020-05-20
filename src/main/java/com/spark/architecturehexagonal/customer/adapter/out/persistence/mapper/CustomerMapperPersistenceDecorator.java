package com.spark.architecturehexagonal.customer.adapter.out.persistence.mapper;

import com.spark.architecturehexagonal.customer.adapter.out.persistence.entity.AddressEntity;
import com.spark.architecturehexagonal.customer.adapter.out.persistence.entity.CustomerEntity;
import com.spark.architecturehexagonal.customer.domain.Address;
import com.spark.architecturehexagonal.customer.domain.Customer;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public abstract class CustomerMapperPersistenceDecorator implements CustomerMapperPersistence {

    @Autowired
    private CustomerMapperPersistence mapper;

    @Override
    public CustomerEntity toEntity(Customer customer) {
        var entity = mapper.toEntity(customer);
        entity.setAddresses(findAddressDomain(customer, entity));
        return entity;
    }

    @Override
    public Customer toDomain(CustomerEntity entity) {
        var domain = mapper.toDomain(entity);
        domain.setAddresses(findAddressEntity(entity));
        return domain;
    }

    private List<Address> findAddressEntity(CustomerEntity entity) {
        return entity.getAddresses().stream().map(end -> Address.builder()
                .describe(end.getDescribe())
                .id(end.getId())
                .build())
                .collect(Collectors.toList());
    }

    private List<AddressEntity> findAddressDomain(Customer customer, CustomerEntity entity) {
        return customer.getAddresses().stream().map(end -> AddressEntity.builder()
                .describe(end.getDescribe())
                .id(end.getId())
                .customer(entity)
                .build())
                .collect(Collectors.toList());
    }
}
