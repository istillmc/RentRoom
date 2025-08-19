package org.atgalway.lease.common.minio;

import io.minio.MinioClient;
import okhttp3.HttpUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfiguration {

    @Autowired
    private  MinioProperties properties;
    @Bean
    public MinioClient minioClient() {
        MinioClient client =
                MinioClient.builder().endpoint(properties.getEndpoint()).
                        credentials(properties.getAccessKey(), properties.getSecretKey()).
                        build();
        return client;
    }
}
