package com.spark.architecturehexagonal.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Customer {

    @EqualsAndHashCode.Include
    private Long id;
    private String uuid;
    @ToString.Include
    private String name;
    private String document;
    private List<Address> addresses = new ArrayList<>();
}
