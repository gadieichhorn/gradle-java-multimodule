package com.rds.example.gradle;

import lombok.extern.slf4j.Slf4j;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.testing.Test;

import java.util.Arrays;

@Slf4j
public class IntegrationPlugin implements Plugin<Project> {

    public void apply(Project project) {

        project.getPlugins().withType(JavaPlugin.class, javaPlugin -> {

            JavaPluginConvention javaConvention = project.getConvention().getPlugin(JavaPluginConvention.class);

            SourceSet main = javaConvention.getSourceSets().getByName(SourceSet.MAIN_SOURCE_SET_NAME);
            SourceSet test = javaConvention.getSourceSets().getByName(SourceSet.TEST_SOURCE_SET_NAME);

            final Configuration integrationImplementation = project.getConfigurations().create("integrationImplementation")
                    .setExtendsFrom(Arrays.asList(project.getConfigurations().getByName("testImplementation")))
                    .setVisible(false)
                    .setDescription("Integration Implementation");

            project.getDependencies().add(integrationImplementation.getName(), "org.testcontainers:testcontainers:1.7.1");

            final Configuration integrationRuntimeOnly = project.getConfigurations().create("integrationRuntimeOnly")
                    .setExtendsFrom(Arrays.asList(project.getConfigurations().getByName("testRuntimeOnly")))
                    .setVisible(false)
                    .setDescription("Integration Runtime Only ");

//            project.getDependencies().add(integrationRuntimeOnly.getName(), "org.testcontainers:testcontainers:1.7.1");

            final SourceSet integration = javaConvention.getSourceSets().create("integration", sourceSet -> {
                sourceSet.setCompileClasspath(project.files(main.getOutput(), test.getOutput()));
                sourceSet.setRuntimeClasspath(project.files(main.getOutput(), test.getOutput()));
                sourceSet.getJava().srcDir(Arrays.asList("src/integration/java"));
                sourceSet.setRuntimeClasspath(sourceSet.getOutput());
                sourceSet.getResources().srcDir("src/integration/resources");
            });

            project.getTasks().create("e2e", Test.class, e2e -> {
                e2e.setTestClassesDirs(integration.getOutput().getClassesDirs());
                e2e.setClasspath(integration.getRuntimeClasspath());
            });

        });


    }

}
