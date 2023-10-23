package cl.tiocomegfas.lib.network.internal.apirest

import cl.tiocomegfas.lib.network.NetworkClient
import cl.tiocomegfas.lib.network.RequestBody
import cl.tiocomegfas.lib.network.ResponseBody
import cl.tiocomegfas.lib.network.ResponseBodyTypes

internal class ApiRestClient(
    private val baseUrl: String,
    private val port: Int,
    private val timeout: Int
): NetworkClient {

    override suspend fun post(headers: Map<String, String>, body: RequestBody) {
        TODO("Not yet implemented")
    }

    override suspend fun get(headers: Map<String, String>) {
        TODO("Not yet implemented")
    }

    override suspend fun put(headers: Map<String, String>, body: RequestBody) {
        TODO("Not yet implemented")
    }

    override suspend fun execute(type: ResponseBodyTypes): ResponseBody {

    }
}