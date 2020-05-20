package com.spark.architecturehexagonal.customer.adapter.out.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;
    @ToString.Include
    @Column(name = "name", nullable = false)
    private String name;
    @ToString.Include
    @Column(name = "document", unique = true, nullable = false)
    private String document;
    @Column(name = "code", nullable = false)
    @ToString.Include
    private String uuid;
    @OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private List<AddressEntity> addresses = new ArrayList<>();
}
