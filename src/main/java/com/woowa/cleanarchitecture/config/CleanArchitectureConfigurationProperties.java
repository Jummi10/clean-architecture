package com.woowa.cleanarchitecture.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "cleanarchitecture")
public class CleanArchitectureConfigurationProperties {
    private Long transferThreshold = Long.MAX_VALUE;
}
