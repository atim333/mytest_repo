package io.vertx.samples.services
import io.vertx.core.AsyncResult
import io.vertx.core.Future
import io.vertx.core.Handler


class TestServiceImpl : TestService {
    override fun test(text: String, handler: Handler<AsyncResult<String>>) {
        handler.handle(Future.succeededFuture("echo: $text"))
    }
}