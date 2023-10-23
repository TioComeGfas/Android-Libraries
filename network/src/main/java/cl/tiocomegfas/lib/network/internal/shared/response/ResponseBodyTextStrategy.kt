package cl.tiocomegfas.lib.network.internal.shared.response

internal class ResponseBodyTextStrategy: ResponseBodyStrategy {

    override suspend fun execute(bytes: ByteArray): String {
        return bytes.contentToString()
    }
}