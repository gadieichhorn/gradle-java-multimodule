package com.rds.example.gradle.server.core;

import com.rds.example.gradle.server.api.Gateway;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class GatewayProvider implements Gateway {

    @Override
    public void process(String name, Consumer<String> greeting) {
        log.info("NAME: {}", name);
        greeting.accept(name.concat(" Yo!"));
    }
}
