package com.spryng.Requests;

import com.spryng.Constants;
import com.spryng.Utils.Filter;
import com.spryng.Utils.RequestMethod;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractRequest implements Constants
{
    public boolean isCollection;

    public List<Filter> filters = new LinkedList<Filter>();

    public abstract RequestMethod getRequestMethod();

    public abstract String getUrlResourceIdentifier();

    public String getEndpoint()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getUrlResourceIdentifier());

        String method = this.getURLMethod();
        if (method != null) {
            sb.append(URL_PATH_SEPARATOR + method);
        }

        return sb.toString();
    }

    public abstract Class<?> getClazz();

    public List<Filter> getFilters()
    {
        return this.filters;
    }

    public void addFilter(Filter filter)
    {
        this.filters.add(filter);
    }

    public boolean getIsCollection()
    {
        return this.isCollection;
    }

    public abstract String getURLMethod();
}