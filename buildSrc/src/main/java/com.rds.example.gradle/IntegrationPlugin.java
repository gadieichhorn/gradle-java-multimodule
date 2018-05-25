package com.rds.example.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;

import java.util.Arrays;

public class IntegrationPlugin implements Plugin<Project> {

    public void apply(Project project) {

        // add a new sourceset (integration)
        project.getPlugins().withType(JavaPlugin.class, javaPlugin -> {
            JavaPluginConvention javaConvention = project.getConvention().getPlugin(JavaPluginConvention.class);
            SourceSet e2e = javaConvention.getSourceSets().create("integration");
            e2e.getJava().setSrcDirs(Arrays.asList("src"));
        });

        // is this needed?
        final Configuration config = project.getConfigurations().create("e2e")
                .setVisible(false)
                .setDescription("do I really needs this bit?");

        // add the dependency only to the integration tests sourceset
        config.defaultDependencies(dependencies -> dependencies.add(project.getDependencies().create("org.testcontainers:testcontainers:1.7.1")));

    }

}
