package cl.tiocomegfas.lib.network.internal.shared.response

internal object ResponseBodyStrategyFactory {

    fun createTextStrategy(): ResponseBodyStrategy {
        return ResponseBodyTextStrategy()
    }

    fun createFileStrategy(path: String): ResponseBodyStrategy {
        return ResponseBodyFileStrategy(path)
    }
}