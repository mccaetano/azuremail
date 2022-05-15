package org.mcc.azuremail.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    private String targetnamespace;
    private List<String> scopes;
    private TimeoutProperties timeouts;
}
