import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String CATS_URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom().build()).build();
        HttpGet request = new HttpGet(CATS_URL);
        CloseableHttpResponse response = httpClient.execute(request);
        List<CatFact> facts = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});
        facts.stream().filter(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0).forEach(System.out::println);
    }
}
