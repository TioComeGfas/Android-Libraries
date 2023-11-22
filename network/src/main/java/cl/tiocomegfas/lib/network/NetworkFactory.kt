package cl.tiocomegfas.lib.network

import cl.tiocomegfas.lib.network.internal.apirest.ApiRestClient

object NetworkFactory {

    fun createApiRestClient(
        baseUrl: String,
        port: Int = 443,
        timeout: Int
    ): NetworkClient {
        return ApiRestClient(baseUrl, port, timeout)
    }

}