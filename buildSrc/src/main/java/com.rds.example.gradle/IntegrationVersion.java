package com.rds.example.gradle;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public final class IntegrationVersion {

    private static final String DEFAULT = "0.1.0";

    private final String major;
    private final String minor;
    private final String patch;

    public String asString() {
        StringBuilder string = new StringBuilder(major);
        if (minor != null) {
            string.append(".").append(minor);
        }
        if (patch != null) {
            string.append(".").append(patch);
        }
        return string.toString();
    }

}