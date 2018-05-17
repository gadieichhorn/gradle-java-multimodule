package com.rds.example.gradle.actions;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class Greeting extends DefaultTask {

    @TaskAction
    public void greet() {
        System.out.println("Greeting from plugin");
    }

}
