/**
 * Copyright (c) 2011 - 2016, Coveo Solutions Inc.
 */
package com.glo3102.config;

public class RestException
{
    private String message;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public RestException withMessage(String message)
    {
        this.message = message;
        return this;
    }
}
