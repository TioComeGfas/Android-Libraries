package cl.tiocomegfas.lib.network.internal

internal abstract class NetworkMethod {
    abstract val method: String

    class Get: NetworkMethod() {
        override val method: String
            get() = "GET"
    }

    class Post: NetworkMethod() {
        override val method: String
            get() = "POST"
    }

    class Put: NetworkMethod() {
        override val method: String
        get() = "PUT"
    }

    object Factory {
        fun createGet(): NetworkMethod = Get()
        fun createPost(): NetworkMethod = Post()
        fun createPut(): NetworkMethod = Put()
    }
}