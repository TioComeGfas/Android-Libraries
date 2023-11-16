package cl.tiocomegfas.lib.network

interface NetworkClient {
    suspend fun https(
        url: String
    ): NetworkClient

    suspend fun http(
        url: String
    ): NetworkClient

    suspend fun query(
        key: String,
        name: Any?
    ): NetworkClient

    suspend fun queries(
        queries: List<Pair<String, Any?>>
    ): NetworkClient

    suspend fun header(
        key: String,
        name: Any
    ): NetworkClient

    suspend fun headers(
        headers: List<Pair<String, Any?>>
    ): NetworkClient

    suspend fun multipart(
        part: Multipart
    ): NetworkClient

    suspend fun jsonStrategy(): NetworkClient

    suspend fun xmlStrategy(): NetworkClient

    suspend fun fileStrategy(path: String): NetworkClient

    suspend fun post(): NetworkClient

    suspend fun get(): NetworkClient

    suspend fun put(body: RequestBody): NetworkClient

    suspend fun execute(): ResponseBody

}