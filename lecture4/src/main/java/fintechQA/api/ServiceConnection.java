package fintechQA.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class ServiceConnection implements ServiceAPI {

    public static final String URL = "https://randus.org/api.php";

    private final HttpClient client = HttpClientBuilder.create().build();

    public HttpClient getHttpClient() {
        return client;
    }

    public HttpResponse getResponse() throws IOException {
        HttpGet request = new HttpGet(URL);
        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("No response from: " + URL);
        }
        return response;
    }

    public String getJson() throws ServiceApiException {
        InputStream in;
        try {
            in = getResponse().getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String line;
            StringBuffer result = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException ex) {
            throw new ServiceApiException(ex);
        }
    }

}
