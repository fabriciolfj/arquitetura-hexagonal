package com.spark.architecturehexagonal.customer.adapter.out.persistence;

import com.spark.architecturehexagonal.customer.adapter.out.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> { }
