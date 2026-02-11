package com.example.contact_management.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app.phone")
@Component
@Getter
@Setter
public class PhoneProperties {

    private String defaultRegion;
}