package com.spark.architecturehexagonal.customer.adapter.out.persistence;

import com.spark.architecturehexagonal.customer.adapter.out.persistence.mapper.CustomerMapperPersistence;
import com.spark.architecturehexagonal.customer.application.port.out.exceptions.CustomerNotFoundException;
import com.spark.architecturehexagonal.customer.application.port.out.exceptions.CustomerUpdateException;
import com.spark.architecturehexagonal.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerPersistenceAdapterImpl implements CustomerPersistenceAdapter {

    private final CustomerRepository repository;
    private final CustomerMapperPersistence mapper;

    @Override
    public Customer create(final Customer customer) {
        var entity = repository.save(mapper.toEntity(customer));
        return mapper.toDomain(entity);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Customer findbyId(final Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found, id:  " + id));
    }

    @Override
    public Customer update(final Long id, final Customer customer) {
        return repository.findById(id).map(entity -> {
            BeanUtils.copyProperties(customer, entity, "id", "addresses", "uuid");
            return repository.save(entity);
        }).map(mapper::toDomain).orElseThrow(() -> new CustomerUpdateException("Fail update customer, id: " + id));
    }
}
