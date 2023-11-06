package cl.tiocomegfas.lib.network.internal.apirest

import cl.tiocomegfas.lib.network.NetworkClient
import cl.tiocomegfas.lib.network.RequestBody
import cl.tiocomegfas.lib.network.internal.BaseNetworkClient
import cl.tiocomegfas.lib.network.internal.NetworkMethod

internal class ApiRestClient(
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
        networkMethod = NetworkMethod.Get()
        return this
    }

    override suspend fun put(body: RequestBody): NetworkClient {
        networkMethod = NetworkMethod.Put()
        return this
    }
}