package cl.tiocomegfas.lib.network.internal.graphql

import cl.tiocomegfas.lib.network.NetworkClient
import cl.tiocomegfas.lib.network.RequestBody
import cl.tiocomegfas.lib.network.ResponseBody

internal class GraphQlClient(
    private val baseUrl: String,
    private val port: Int,
    private val timeout: Int
): NetworkClient {

    override suspend fun post(headers: Map<String, String>, body: RequestBody): ResponseBody {
        TODO("Not yet implemented")
    }

    override suspend fun get(headers: Map<String, String>): ResponseBody {
        throw UnsupportedOperationException()
    }

    override suspend fun put(headers: Map<String, String>, body: RequestBody): ResponseBody {
        throw UnsupportedOperationException()
    }
}