package com.rds.example.gradle.server.api;

import java.util.function.Consumer;

public interface Gateway {

    void process(String name, Consumer<String> greeting);

}
