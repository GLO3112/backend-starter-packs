package com.glo3102.exceptions;

public abstract class ServiceClientSideException extends Exception
{
    private static final long serialVersionUID = -1935643026583852798L;

    protected ServiceClientSideException(String message)
    {
        super(message);
    }

    protected ServiceClientSideException(String message,
                                         Throwable e)
    {
        super(message, e);
    }
}