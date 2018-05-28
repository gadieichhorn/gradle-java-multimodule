package com.rds.example.gradle;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.gradle.api.Project;
import org.gradle.api.provider.Property;

import java.io.File;

@Slf4j
@ToString
public class IntegrationExtension {

    @Getter
    private Property<String> folder;

    public IntegrationExtension(Project project) {
        folder = project.getObjects().property(String.class);
    }

}
