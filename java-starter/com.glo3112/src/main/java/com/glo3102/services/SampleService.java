package com.glo3102.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.glo3102.exceptions.MissingParameterException;
import com.glo3102.models.SampleGetModel;
import com.glo3102.models.SampleUploadModel;
import com.glo3102.repositories.SampleS3Repository;

public class SampleService
{
    private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

    private SampleS3Repository s3Repository;

    public SampleService(SampleS3Repository s3Repository)
    {
        this.s3Repository = s3Repository;
    }

    public String getSample()
    {
        return "This is a sample";
    }

    public SampleGetModel getParametrizedSample(String value)
    {
        logger.info("Getting value '{}'", value);

        return new SampleGetModel().withValue(value);
    }

    public void uploadSample(SampleUploadModel uploadModel) throws MissingParameterException
    {
        if (uploadModel == null) {
            throw new MissingParameterException("uploadModel");
        }
        if (StringUtils.isEmpty(uploadModel.getValue())) {
            throw new MissingParameterException("uploadModel.value");
        }

        logger.info("Uploading a sample value");

        s3Repository.upload(uploadModel.getValue());
    }
}