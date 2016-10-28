package com.glo3102.models;

public class SampleGetModel
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

    public SampleGetModel withValue(String value)
    {
        setValue(value);
        return this;
    }
}
