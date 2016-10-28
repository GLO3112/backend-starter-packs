package com.glo3102.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.glo3102.repositories.SampleS3Repository;
import com.glo3102.services.SampleService;

@Configuration
public class SampleConfig
{
    @Value("${aws.s3.bucketName}")
    private String bucketName;
    @Value("${aws.s3.folderName}")
    private String folderName;

    @Bean
    public SampleS3Repository sampleS3Repository()
    {
        return new SampleS3Repository(amazonS3Client(), bucketName, folderName);
    }

    @Bean
    public SampleService sampleService()
    {
        return new SampleService(sampleS3Repository());
    }

    @Bean
    public AmazonS3 amazonS3Client()
    {
        // Read http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html to see where credentials are taken.
        return new AmazonS3Client(new DefaultAWSCredentialsProviderChain());
    }
}
