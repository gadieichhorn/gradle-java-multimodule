package com.rds.example.gradle.deploy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import java.util.stream.Stream;

@Slf4j
public class DeployTest {

    private static GenericContainer main = new GenericContainer("com.rds.example.gradle/rest:latest")
            .withExposedPorts(8080);

    static {
        Stream.of(main).parallel().forEach(c -> c.start());
    }

    @BeforeAll
    static void before() {
        Slf4jLogConsumer logConsumer = new Slf4jLogConsumer(log);
        main.followOutput(logConsumer);
        Assertions.assertNotNull(main);
        Assertions.fail("BOOM");
    }

    @Test
    void canReacheServerPortTest() {
        Assertions.fail("BOOM");
        Assertions.assertFalse(main.getMappedPort(8080) == null);
    }

}
