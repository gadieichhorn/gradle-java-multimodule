package com.rds.example.gradle.actions;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class IntegrationTestTask extends DefaultTask {

    private final Property<String> folder;

    public IntegrationTestTask() {
        folder = getProject().getObjects().property(String.class);
    }

    @Input
    public Property<String> getFolder() {
        return folder;
    }

    @TaskAction
    public void greet() {
        System.out.println("Greeting from integration plugin " + folder.toString());
    }

}
