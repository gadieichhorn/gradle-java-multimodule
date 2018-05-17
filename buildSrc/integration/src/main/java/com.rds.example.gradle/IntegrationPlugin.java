package com.rds.example.gradle;

import com.rds.example.gradle.actions.Greeting;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class IntegrationPlugin implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        target.getTasks().create("greetingAction", Greeting.class);
    }

}
