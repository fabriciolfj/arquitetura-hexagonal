package com.spark.architecturehexagonal.customer.adapter.out.persistence;

import com.spark.architecturehexagonal.customer.domain.Customer;
import java.util.List;
public interface CustomerPersistenceAdapter {

    Customer create(final Customer customer);
    void delete(final Long id);
    List<Customer> findAll();
    Customer findbyId(final Long id);
    Customer update(final Long id, final Customer customer);
}
