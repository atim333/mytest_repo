package io.vertx.samples.services
import io.vertx.codegen.annotations.ProxyGen
import io.vertx.codegen.annotations.VertxGen
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

@ProxyGen
@VertxGen
interface TestService {
    fun test(text: String, handler: Handler<AsyncResult<String>>)
}