package cl.tiocomegfas.lib.network.internal.shared.response

import java.io.File

internal class ResponseBodyFileStrategy(
    private val path: String
): ResponseBodyStrategy {

    override suspend fun execute(bytes: ByteArray): File {
        return File(path).apply {
            writeBytes(bytes)
        }
    }
}