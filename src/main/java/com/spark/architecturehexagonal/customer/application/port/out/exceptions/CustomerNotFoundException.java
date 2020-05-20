package com.spark.architecturehexagonal.customer.application.port.out.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final Throwable cause, final String msg) {
        super(msg, cause);
    }

    public CustomerNotFoundException(final String msg) {
        super(msg);
    }
}
