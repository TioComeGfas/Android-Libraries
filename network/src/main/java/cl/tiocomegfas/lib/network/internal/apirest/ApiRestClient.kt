package cl.tiocomegfas.lib.network.internal.apirest

import android.graphics.Bitmap
import androidx.annotation.IntRange
import cl.tiocomegfas.lib.network.NetworkClient
import cl.tiocomegfas.lib.network.NetworkHeader
import cl.tiocomegfas.lib.network.NetworkQuery
import cl.tiocomegfas.lib.network.NetworkUrl
import cl.tiocomegfas.lib.network.ResponseBody
import cl.tiocomegfas.lib.network.internal.NetworkMethod
import cl.tiocomegfas.lib.network.internal.shared.request.MultipartBody
import cl.tiocomegfas.lib.network.internal.shared.request.RequestBody
import cl.tiocomegfas.lib.network.internal.util.jpegToStream

internal class ApiRestClient(
    baseUrl: String,
    port: Int,
    timeout: Int
): NetworkClient {
    private var url: NetworkUrl? = null
    private var headers: List<NetworkHeader> = emptyList()
    private var method: NetworkMethod? = null
    private var request: RequestBody? = null

    override suspend fun https(url: String): NetworkClient {
        this.url = NetworkUrl.Factory.createHttps(url)
        return this
    }

    override suspend fun http(url: String): NetworkClient {
        this.url = NetworkUrl.Factory.createHttp(url)
        return this
    }

    override suspend fun query(key: String, value: String): NetworkClient {
        if(url == null) throw IllegalStateException("define url before to start")
        url?.addQuery(NetworkQuery(key, value))
        return this
    }

    override suspend fun header(key: String, value: String): NetworkClient {
        headers = headers.plus(NetworkHeader(key, value))
        return this
    }

    override suspend fun addImageToBody(
        image: Bitmap?,
        @IntRange(from = 0.toLong(), to = 100.toLong()) quality: Int
    ): NetworkClient {
        insertFormDataHeader()
        val data: ByteArray = image.jpegToStream(quality)


        return this
    }

    override suspend fun body(data: RequestBody): NetworkClient {
        request = data
        return this
    }

    override suspend fun post(): NetworkClient {
        method = NetworkMethod.Factory.createPost()
        return this
    }

    override suspend fun get(): NetworkClient {
        method = NetworkMethod.Factory.createGet()
        return this
    }

    override suspend fun put(body: cl.tiocomegfas.lib.network.RequestBody): NetworkClient {
        method = NetworkMethod.Factory.createPut()
        return this
    }

    override suspend fun execute(): ResponseBody {
        TODO("Not yet implemented")
    }

    private fun insertFormDataHeader() {
        if(headers.firstOrNull { it.key == "Content-Type" } == null) {
            headers = headers.plus(
                NetworkHeader("Content-Type", "multipart/form-data; boundary=" +  "=== "+ System.currentTimeMillis() + " ===")
            )
        }
    }

}