package com.spryng.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Filter
{
    public String operandA;

    public String operandB;

    public FilterOperator operator;

    public Filter()
    {

    }

    public Filter(String operandA, FilterOperator operator, String operandB)
    {
        this.operandA = operandA;
        this.operator = operator;
        this.operandB = operandB;
    }

    public String operandAToString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("filters[" + this.operandA + "]");

        return sb.toString();
    }

    public String operandBToString()
    {
        StringBuilder sb = new StringBuilder();
        String encoding = "UTF-8";

        try
        {
            switch(this.operator)
            {
                case EQUALS:
                    sb.append("=");
                    break;
                case DOES_NOT_EQUAL:
                    sb.append("!=");
                    break;
                case GREATER_THAN:
                    sb.append(">");
                    break;
                case GREATER_THAN_OR_EQUALS:
                    sb.append(">=");
                    break;
                case LESS_THAN:
                    sb.append("<");
                    break;
                case LESS_THAN_OR_EQUALS:
                    sb.append("<=");
                    break;
            }

            sb.append(URLEncoder.encode(this.operandB, encoding));
        }
        catch (UnsupportedEncodingException exception)
        {
            return "";
        }

        return sb.toString();
    }

    @Override
    public String toString()
    {
        return this.operandAToString() + this.operandBToString();
    }
}