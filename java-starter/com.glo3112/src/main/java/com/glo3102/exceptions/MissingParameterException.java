package com.glo3102.exceptions;

public class MissingParameterException extends ServiceClientSideException
{
    private static final long serialVersionUID = 1L;

    public MissingParameterException(String parameter)
    {
        super(getMessage(parameter));
    }

    public MissingParameterException(String parameter,
                                     Throwable e)
    {
        super(getMessage(parameter), e);
    }

    private static String getMessage(String parameter)
    {
        return String.format("Parameter '%s' is missing.", parameter);
    }
}
