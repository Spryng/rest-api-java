package com.spryng.Exceptions;

public class SpryngException extends Exception
{
    /**
     * The Field.
     */
    protected String field;

    public SpryngException(String message, int code)
    {
        super(message);
    }

    /**
     * Gets field.
     *
     * @return the field
     */
    public String getField()
    {
        return field;
    }

    /**
     * Sets field.
     *
     * @param field the field
     */
    public void setField(String field)
    {
        this.field = field;
    }
}