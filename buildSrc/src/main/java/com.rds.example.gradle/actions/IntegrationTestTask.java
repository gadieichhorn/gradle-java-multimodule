package com.rds.example.gradle.actions;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class IntegrationTestTask extends DefaultTask {

    @TaskAction
    public void greet() {
        System.out.println("Greeting from integration plugin");
    }

}
