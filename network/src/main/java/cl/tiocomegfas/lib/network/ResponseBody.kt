package cl.tiocomegfas.lib.network

data class ResponseBody(
    val bytes: ByteArray?,
    val code: ResponseCode
)