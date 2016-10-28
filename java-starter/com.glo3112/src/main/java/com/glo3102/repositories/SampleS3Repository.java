package com.glo3102.repositories;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class SampleS3Repository
{
    private static final Logger logger = LoggerFactory.getLogger(SampleS3Repository.class);

    private AmazonS3 s3Client;
    private String bucketName;
    private String folderName;

    public SampleS3Repository(AmazonS3 s3Client,
                              String bucketName,
                              String folderName)
    {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
        this.folderName = folderName;
    }

    public void upload(String value)
    {
        logger.info("Uploading '{}' to folder '{}' in bucket '{}'", value, folderName, bucketName);

        try {
            File file = File.createTempFile(value, ".json");
            s3Client.putObject(new PutObjectRequest(bucketName, folderName + "/" + value, file));
        } catch (AmazonServiceException | IOException e) {
            logger.error("Unable to upload file to S3", e);
        }
    }
}