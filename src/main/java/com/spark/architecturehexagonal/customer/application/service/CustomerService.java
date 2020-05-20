package com.spark.architecturehexagonal.customer.application.service;

import com.spark.architecturehexagonal.customer.adapter.out.persistence.CustomerPersistenceAdapter;
import com.spark.architecturehexagonal.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerPersistenceAdapter adapter;

    @Transactional
    public Customer create(Customer customer) {
        log.info("create customer: " + customer.toString());
        customer.setUuid(UUID.randomUUID().toString());
        return adapter.create(customer);
    }

    @Transactional(readOnly = true, propagation = Propagation.NEVER)
    public List<Customer> findAll() {
        return adapter.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.NEVER)
    public Customer findbyId(Long id) {
        return adapter.findbyId(id);
    }

    @Transactional
    public void delete(Long id) {
        adapter.delete(id);
    }

    @Transactional
    public Customer update(Long id, Customer customer) {
        return adapter.update(id, customer);
    }
}
