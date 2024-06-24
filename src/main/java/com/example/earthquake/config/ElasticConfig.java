package com.example.earthquake.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

public class ElasticConfig {

    private String serverUrl = "http://localhost:9200";
    private String apiKey = "OUY5dU9wQUJZZExfYUNtVVJwR2M6T2d4YU5sSW1USXVMUU1vT1BVQjFYZw==";

    @Bean
    public RestClient elasticRestClient() {
        return RestClient.builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[] { new BasicHeader("Authorization", "ApiKey " + apiKey) }).build();
    }

    @Bean
    public ElasticsearchTransport elasticTransport(final RestClient elasticRestClient) {
        return new RestClientTransport(elasticRestClient, new JacksonJsonpMapper());
    }

    @Bean
    public ElasticsearchClient elasticTransport(final ElasticsearchTransport elasticTransport) {
        return new ElasticsearchClient(elasticTransport);
    }
}
