package com.glo3102.models;

public class SampleUploadModel
{
    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public SampleUploadModel withValue(String value)
    {
        setValue(value);
        return this;
    }
}
