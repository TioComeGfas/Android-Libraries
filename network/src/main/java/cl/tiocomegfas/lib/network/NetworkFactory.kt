package cl.tiocomegfas.lib.network

import cl.tiocomegfas.lib.network.internal.apirest.ApiRestClient
import cl.tiocomegfas.lib.network.internal.graphql.GraphQlClient

object NetworkFactory {

    fun createApiRestClient(
        baseUrl: String,
        port: Int,
        timeout: Int
    ): NetworkClient {
        return ApiRestClient(baseUrl, port, timeout)
    }

    fun createGraphQlClient(
        baseUrl: String,
        port: Int,
        timeout: Int
    ): NetworkClient {
        return GraphQlClient(baseUrl, port, timeout)
    }
}