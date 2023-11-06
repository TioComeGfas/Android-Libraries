package cl.tiocomegfas.lib.network.internal.graphql

import cl.tiocomegfas.lib.network.NetworkClient
import cl.tiocomegfas.lib.network.RequestBody
import cl.tiocomegfas.lib.network.ResponseBody
import cl.tiocomegfas.lib.network.internal.BaseNetworkClient
import cl.tiocomegfas.lib.network.internal.NetworkMethod

internal class GraphQlClient(
    baseUrl: String,
    port: Int,
    timeout: Int
): BaseNetworkClient(baseUrl, port, timeout) {

    override suspend fun post(body: RequestBody): NetworkClient {
        networkMethod = NetworkMethod.Post()
        request = body
        return this
    }

    override suspend fun get(): NetworkClient {
        throw UnsupportedOperationException()
    }

    override suspend fun put(body: RequestBody): NetworkClient {
        throw UnsupportedOperationException()
    }
}