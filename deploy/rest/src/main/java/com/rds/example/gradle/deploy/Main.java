package com.rds.example.gradle.deploy;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {

    public static void main(String [] args) {
        log.info("ARGS: {}", Arrays.asList(args));

        Vertx.vertx().deployVerticle(new MainVerticle(), stringAsyncResult -> {
            log.info("DEPLOYED: {}", stringAsyncResult.result());
        });

    }

}
