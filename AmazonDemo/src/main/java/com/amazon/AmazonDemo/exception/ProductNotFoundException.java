package com.amazon.AmazonDemo.exception;

public class ProductNotFoundException extends Exception
{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
