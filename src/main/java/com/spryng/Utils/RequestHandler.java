package com.spryng.Utils;

import com.spryng.Constants;

import com.google.gson.*;
import com.spryng.Exceptions.RequestException;
import com.spryng.Models.BaseObject;
import com.spryng.Models.MessageList;
import com.spryng.Requests.AbstractRequest;
import com.spryng.Spryng;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class RequestHandler implements Constants
{
    protected AbstractRequest request;

    protected CloseableHttpClient httpClient;

    protected Gson deserialize;

    protected JsonParser jsonParser;

    protected String baseUrl;

    protected final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";

    protected ArrayList<Header> headers = new ArrayList<>();

    protected List<Filter> filters = new LinkedList<Filter>();

    protected int responseCode;

    protected String response;

    protected BaseObject postEntity;

    public RequestHandler()
    {
        this.deserialize = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();

        this.headers.add(new BasicHeader(HDR_USER_AGENT, USER_AGENT));
        this.headers.add(new BasicHeader(HDR_CONTENT_TYPE, JSON_CONTENT_TYPE));

        this.httpClient = HttpClients.createDefault();

        this.setBaseUrl(Spryng.getEndpoint());
    }

    public void send() throws RequestException
    {
        URI uri = this.createUri(this.request);
        if (this.request.getRequestMethod() == RequestMethod.GET)
        {
            this.response = this.doGet(uri);
        }
        else if (this.request.getRequestMethod() == RequestMethod.POST)
        {
            this.response = this.doPost(uri);
        }
        else if (this.request.getRequestMethod() == RequestMethod.DELETE)
        {
            this.response = this.doDelete(uri);
        }
    }

    private String doGet(URI uri) throws RequestException
    {
        HttpGet get = new HttpGet(uri);

        for (Header header : this.headers)
        {
            get.setHeader(header.getName(), header.getValue());
        }

        return executeHttpRequest(get);
    }

    private String doPost(URI uri) throws RequestException
    {
        HttpPost post = new HttpPost(uri);

        for (Header header : this.headers)
        {
            post.setHeader(header.getName(), header.getValue());
        }

        StringEntity jsonToPost;
        try
        {
            jsonToPost = new StringEntity(this.getPostEntity().toJson());
        }
        catch (UnsupportedEncodingException ex)
        {
            throw new RequestException("Could not parse JSON to POST", 103);
        }

        post.setEntity(jsonToPost);

        return executeHttpRequest(post);
    }

    public String doDelete(URI uri) throws RequestException
    {
        HttpDelete delete = new HttpDelete(uri);

        for (Header header : this.headers)
        {
            delete.setHeader(header.getName(), header.getValue());
        }

        return executeHttpRequest(delete);
    }

    private String executeHttpRequest(HttpUriRequest request) throws RequestException
    {
        CloseableHttpResponse httpResponse = null;
        String response = "";

        try
        {
            httpResponse = httpClient.execute(request);
            response = evaluateResponse(httpResponse);

        }
        catch(IOException exception)
        {
            throw new RequestException("Request was unsuccessfull", 101);
        }
        finally
        {
            try
            {
                if (null != httpResponse)
                {
                    httpResponse.close();
                }
            }
            catch (IOException exception)
            {
                throw new RequestException("Could not close HTTP Response", 101);
            }
        }

        return response;
    }

    public Response getDeserializedResponse()
    {
        Response response = new Response(this.request, true);

        try
        {
            response.setData(deserialize.fromJson(this.getResponse(), this.request.getClazz()));
        }
        catch (JsonSyntaxException jse)
        {
            response.setRequestWasSuccessful(false);
        }

        return response;
    }

    private String evaluateResponse(HttpResponse httpResponse) throws RequestException
    {
        this.responseCode = httpResponse.getStatusLine().getStatusCode();
        String response = "";

        if (HttpStatus.SC_OK == this.responseCode)
        {
            response = httpResponseToString(httpResponse);
        }
        else
        {
            throw new RequestException("Request is not 200 OK: " + httpResponseToString(httpResponse), 101);
        }

        return response;
    }

    private String httpResponseToString(HttpResponse httpResponse) throws RequestException
    {
        String response = "";
        if (null != httpResponse.getEntity())
        {
            try
            {
                response = EntityUtils.toString(httpResponse.getEntity(), UTF_8);
            }
            catch (ParseException e)
            {
                throw new RequestException("Could not parse response", 101);
            }
            catch (IOException ioe)
            {
                throw new RequestException("Could not read response", 101);
            }
        }

        return response;
    }

    private URI createUri(AbstractRequest request)
    {
        URIBuilder ub = new URIBuilder();
        ub.setScheme(HTTP_SCHEME);
        ub.setHost(Spryng.getEndpoint());
        ub.setPath(createPath(request));

        if (this.filters.size() > 0)
        {
            Iterator<Filter> it = this.filters.iterator();

            String query = "";
            int count = 0;
            while(it.hasNext())
            {
                Filter filter = it.next();
                if (count != 0)
                {
                    query += "&";
                }

                query += filter.toString();

                count++;
            }
            ub.setCustomQuery(query);
        }

        URI uri = null;
        try
        {
            uri = ub.build();
        }
        catch (URISyntaxException exception)
        {
            return uri;
        }

        return uri;
    }

    private String createPath(AbstractRequest request)
    {
        return URL_PATH_SEPARATOR + API_VERSION + URL_PATH_SEPARATOR + request.getEndpoint();
    }

    public void setRequest(AbstractRequest request)
    {
        this.request = request;
    }

    public void addHeader(String key, String value)
    {
        this.headers.add(new BasicHeader(key, value));
    }

    public String getResponse()
    {
        return response;
    }

    public void addFilter(Filter filter)
    {
        this.filters.add(filter);
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    protected BaseObject getPostEntity()
    {
        return postEntity;
    }

    public void setPostEntity(BaseObject postEntity)
    {
        this.postEntity = postEntity;
    }
}