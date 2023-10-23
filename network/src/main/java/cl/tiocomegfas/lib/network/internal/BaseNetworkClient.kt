package cl.tiocomegfas.lib.network.internal

import android.net.NetworkRequest
import cl.tiocomegfas.lib.network.NetworkClient
import cl.tiocomegfas.lib.network.NetworkHeader
import cl.tiocomegfas.lib.network.NetworkQuery
import cl.tiocomegfas.lib.network.NetworkUrl
import cl.tiocomegfas.lib.network.RequestBody
import cl.tiocomegfas.lib.network.ResponseBody
import cl.tiocomegfas.lib.network.internal.shared.response.ResponseBodyStrategy
import cl.tiocomegfas.lib.network.internal.shared.response.ResponseBodyStrategyFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.OutputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

internal abstract class BaseNetworkClient(
    private val baseUrl: String,
    private val port: Int,
    private val timeout: Int
): NetworkClient {
    protected var networkUrl: NetworkUrl = NetworkUrl.Factory.createDefault()
    protected var request: RequestBody? = null
    protected var networkMethod: NetworkMethod = NetworkMethod.Factory.createDefault()
    protected var listHeader: List<NetworkHeader> = emptyList()
    protected var responseStrategy: ResponseBodyStrategy = ResponseBodyStrategyFactory.createTextStrategy()

    override suspend fun url(url: NetworkUrl): NetworkClient {
        this.networkUrl = url
        return this
    }

    override suspend fun query(query: NetworkQuery): NetworkClient {
        if(networkUrl is NetworkUrl.DefaultUrl) throw UnsupportedOperationException("Please first set url to network request")
        networkUrl.addQuery(query)
        return this
    }

    override suspend fun queries(queries: List<NetworkQuery>): NetworkClient {
        if(networkUrl is NetworkUrl.DefaultUrl) throw UnsupportedOperationException("Please first set url to network request")
        queries.forEachIndexed { _, networkQuery ->
            networkUrl.addQuery(networkQuery)
        }
        return this
    }

    override suspend fun header(header: NetworkHeader): NetworkClient {
        if(!listHeader.contains(header)) listHeader = listHeader.plus(header)
        return this
    }

    override suspend fun headers(headers: List<NetworkHeader>): NetworkClient {
        headers.forEachIndexed { _, networkHeader ->
            if(!listHeader.contains(networkHeader)) listHeader = listHeader.plus(networkHeader)
        }
        return this
    }

    override suspend fun jsonStrategy(): NetworkClient {
        responseStrategy = ResponseBodyStrategyFactory.createTextStrategy()
        return this
    }

    override suspend fun xmlStrategy(): NetworkClient {
        responseStrategy = ResponseBodyStrategyFactory.createTextStrategy()
        return this
    }

    override suspend fun fileStrategy(path: String): NetworkClient {
        responseStrategy = ResponseBodyStrategyFactory.createFileStrategy(path)
        return this
    }

    override suspend fun execute(): ResponseBody {
        return withContext(Dispatchers.IO) {
            val client = networkUrl.createConnectionClient(baseUrl)
            networkMethod.configureMethod(client)
            client.configureTimeout(timeout)
            client.configureHeaders(listHeader)
            client.configureRequestBody(request)
            client.connect()
            return@withContext client.responseBody()
        }
    }

    open fun release() {
        networkUrl = NetworkUrl.Factory.createDefault()
        listHeader = emptyList()
        responseStrategy = ResponseBodyStrategyFactory.createTextStrategy()
    }
}