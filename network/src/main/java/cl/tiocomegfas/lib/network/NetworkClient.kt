package cl.tiocomegfas.lib.network

interface NetworkClient {

    suspend fun url(
        url: NetworkUrl
    ): NetworkClient

    suspend fun query(
        query: NetworkQuery
    ): NetworkClient

    suspend fun queries(
        queries: List<NetworkQuery>
    ): NetworkClient

    suspend fun header(
        header: NetworkHeader
    ): NetworkClient

    suspend fun headers(
        headers: List<NetworkHeader>
    ): NetworkClient

    suspend fun jsonStrategy(): NetworkClient

    suspend fun xmlStrategy(): NetworkClient

    suspend fun fileStrategy(path: String): NetworkClient

    suspend fun post(
        body: RequestBody
    ): NetworkClient

    suspend fun get(): NetworkClient

    suspend fun put(body: RequestBody): NetworkClient

    suspend fun execute(): ResponseBody

}