package com.glo3102.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glo3102.exceptions.MissingParameterException;
import com.glo3102.models.SampleGetModel;
import com.glo3102.models.SampleUploadModel;
import com.glo3102.services.SampleService;

@RestController
public class SampleController
{
    @Autowired
    private SampleService service;

    // Very simple GET.
    @RequestMapping("/")
    @ResponseBody
    public String sample()
    {
        return service.getSample();
    }

    // GET returning a JSON model.
    @RequestMapping("/{value}")
    @ResponseBody
    public SampleGetModel parametrizedSample(@PathVariable String value)
    {
        return service.getParametrizedSample(value);
    }

    // POST uploading a value in s3.
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void upload(@RequestBody SampleUploadModel editModel) throws MissingParameterException
    {
        service.uploadSample(editModel);
    }
}
