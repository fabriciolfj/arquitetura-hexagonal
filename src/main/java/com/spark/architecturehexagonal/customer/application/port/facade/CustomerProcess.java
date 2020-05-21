package com.spark.architecturehexagonal.customer.application.port.facade;

import com.spark.architecturehexagonal.customer.application.port.in.dto.CustomerRequestDto;
import com.spark.architecturehexagonal.customer.application.port.in.mapper.CustomerRequestMapper;
import com.spark.architecturehexagonal.customer.application.port.out.dto.CustomerResponseDto;
import com.spark.architecturehexagonal.customer.application.port.out.mapper.CustomerResponseMapper;
import com.spark.architecturehexagonal.customer.application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerProcess {

    private final CustomerService customerService;
    private final CustomerRequestMapper mapperRequest;
    private final CustomerResponseMapper mapperResponse;

    public CustomerResponseDto create(final CustomerRequestDto dto) {
        var customer = customerService.create(mapperRequest.toDomain(dto));
        return mapperResponse.toDto(customer);
    }

    public List<CustomerResponseDto> findAll() {
        return customerService.findAll()
                .stream()
                .map(c -> mapperResponse.toDto(c))
                .collect(Collectors.toList());
    }

    public CustomerResponseDto findId(final Long id) {
        return mapperResponse.toDto(customerService.findbyId(id));
    }

    public void delete(final Long id) {
        customerService.delete(id);
    }

    public CustomerResponseDto update(final Long id, final CustomerRequestDto requestDto) {
        var customer = customerService.update(id, mapperRequest.toDomain(requestDto));
        return mapperResponse.toDto(customer);
    }

}
