package com.spark.architecturehexagonal.customer.adapter.in.web;

import com.spark.architecturehexagonal.customer.application.port.in.dto.CustomerRequestDto;
import com.spark.architecturehexagonal.customer.application.port.facade.CustomerProcess;
import com.spark.architecturehexagonal.customer.application.port.out.dto.CustomerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerProcess process;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto save(@Valid @RequestBody final CustomerRequestDto requestDto) {
        return process.create(requestDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerResponseDto findId(@PathVariable("id") final Long id) {
        return process.findId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CustomerResponseDto> findAll() {
        return process.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") final Long id) {
        process.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto update(@Valid @RequestBody final CustomerRequestDto requestDto, @PathVariable("id") final Long id) {
        return process.update(id, requestDto);
    }
}
