package com.rds.example.gradle.deploy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainVerticle extends AbstractVerticle {

    private HttpServeer server;

    @Override
    public void start(Future<Void> startFuture) {

        server = vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        });

        // Now bind the server:
        server.listen(8080, res -> {
            if (res.succeeded()) {
                startFuture.complete();
            } else {
                startFuture.fail(res.cause());
            }
        });

    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        server.close(voidAsyncResult -> {
            if (voidAsyncResult.succeeded()) {
                stopFuture.complete();
            } else {
                log.error("Exception", voidAsyncResult.cause());
                stopFuture.fail(voidAsyncResult.cause());
            }
        });
    }

}
