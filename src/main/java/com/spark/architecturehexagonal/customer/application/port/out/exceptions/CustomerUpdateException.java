package com.spark.architecturehexagonal.customer.application.port.out.exceptions;

public class CustomerUpdateException extends RuntimeException {

    public CustomerUpdateException(final Throwable cause, final String msg) {
        super(msg, cause);
    }

    public CustomerUpdateException(final String msg) {
        super(msg);
    }
}
