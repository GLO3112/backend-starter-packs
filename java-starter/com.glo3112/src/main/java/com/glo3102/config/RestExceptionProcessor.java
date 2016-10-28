package com.glo3102.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.glo3102.exceptions.ServiceClientSideException;

@ControllerAdvice("com.glo3102")
public class RestExceptionProcessor
{
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionProcessor.class);

    @ExceptionHandler(ServiceClientSideException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestException serviceClientSideException(ServiceClientSideException e)
    {
        return new RestException().withMessage(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestException unexpectedException(Exception e)
    {
        logger.error("Unexpected error", e);

        return new RestException().withMessage("Unexpected error");
    }
}