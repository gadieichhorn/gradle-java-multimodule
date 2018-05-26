package com.rds.example.gradle.deploy;

import io.vertx.core.Vertx;
import io.vertx.junit5.Timeout;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Slf4j
@ExtendWith(VertxExtension.class)
class MainTest {

    @Test
    @Timeout(1000)
    void canStartInstanceTest(Vertx vertx, VertxTestContext context) {
        log.info("TEST");
        vertx.deployVerticle(new MainVerticle(), context.succeeding());
    }

}