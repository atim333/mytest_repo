import io.vertx.core.Launcher
import verticle.MainVerticle
import g4.Library

fun main() {
    val lib=Library()
    println(lib.someLibraryMethod())
    Launcher.executeCommand("run", MainVerticle::class.java.name)
}