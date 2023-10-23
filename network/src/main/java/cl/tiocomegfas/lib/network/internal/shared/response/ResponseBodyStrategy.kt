package cl.tiocomegfas.lib.network.internal.shared.response

interface ResponseBodyStrategy {
    suspend fun execute(bytes: ByteArray): Any
}



