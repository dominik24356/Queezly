package com.opensource.queezly.config.cors;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
@ConfigurationProperties(prefix = CorsFilterProperties.PREFIX)
class CorsFilterProperties {

    public static final String PREFIX = "web.filter.cors";

    private int order = 100;

    private List<String> allowedOrigins;

    private List<String> allowedMethods;

    private List<String> allowedHeaders;

    private Long maxAge;
}