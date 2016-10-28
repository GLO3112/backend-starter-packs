package com.glo3102.service;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.glo3102.exceptions.MissingParameterException;
import com.glo3102.models.SampleUploadModel;
import com.glo3102.repositories.SampleS3Repository;
import com.glo3102.services.SampleService;

@RunWith(MockitoJUnitRunner.class)
public class SampleServiceTest
{
    private static final String A_VALUE = "hg blame wfortin for this";

    @Mock
    private SampleS3Repository sampleS3RepositoryMock;

    private SampleService service;

    @Before
    public void setUp()
    {
        service = new SampleService(sampleS3RepositoryMock);
    }

    @Test(expected = MissingParameterException.class)
    public void testUploadThrowsWithNullModel() throws Exception
    {
        service.uploadSample(null);
    }

    @Test(expected = MissingParameterException.class)
    public void testUploadThrowsWithModelWithNullValue() throws Exception
    {
        service.uploadSample(givenASampleUploadModel().withValue(null));
    }

    @Test(expected = MissingParameterException.class)
    public void testUploadThrowsWithModelWithEmptyValue() throws Exception
    {
        service.uploadSample(givenASampleUploadModel().withValue(""));
    }

    @Test
    public void testUpload() throws Exception
    {
        service.uploadSample(givenASampleUploadModel());

        verify(sampleS3RepositoryMock).upload(A_VALUE);
    }

    private SampleUploadModel givenASampleUploadModel()
    {
        return new SampleUploadModel().withValue(A_VALUE);
    }
}
