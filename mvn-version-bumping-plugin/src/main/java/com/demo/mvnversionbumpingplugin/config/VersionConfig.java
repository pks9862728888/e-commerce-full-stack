package com.demo.mvnversionbumpingplugin.config;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "version")
@Getter
@Setter
public class VersionConfig {

    @NonNull
    private Boolean bumpMajor;
    @NonNull
    private Boolean bumpMinor;
    @NonNull
    private Boolean bumpPatch;
    @NonNull
    private String suffix;
}
