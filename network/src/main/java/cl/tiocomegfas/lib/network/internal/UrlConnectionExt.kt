package cl.tiocomegfas.lib.network.internal

import cl.tiocomegfas.lib.network.NetworkHeader
import cl.tiocomegfas.lib.network.NetworkUrl
import cl.tiocomegfas.lib.network.RequestBody
import cl.tiocomegfas.lib.network.ResponseBody
import cl.tiocomegfas.lib.network.ResponseCode
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

internal fun NetworkUrl.createConnectionClient(baseUrl: String): HttpURLConnection {
    val url = URL(this.getUrl(baseUrl))
    return when(this) {
        is NetworkUrl.HttpUrl -> url.openConnection() as HttpURLConnection
        is NetworkUrl.HttpsUrl -> url.openConnection() as HttpsURLConnection
        else -> throw UnsupportedOperationException()
    }
}

internal fun NetworkMethod.configureMethod(client: HttpURLConnection) {
    when(this) {
        is NetworkMethod.Default -> throw UnsupportedOperationException()
        else -> client.requestMethod = method
    }
}

internal fun HttpURLConnection.configureTimeout(timeout: Int) {
    this.connectTimeout = timeout
    this.readTimeout = timeout
}

internal fun HttpURLConnection.configureHeader(header: NetworkHeader) {
    this.setRequestProperty(header.key, header.value)
}

internal fun HttpURLConnection.configureHeaders(headers: List<NetworkHeader>) {
    headers.forEachIndexed { _, networkHeader ->
        this.setRequestProperty(networkHeader.key, networkHeader.value)
    }
}

internal fun HttpURLConnection.configureRequestBody(body: RequestBody?) {
    if(body == null) return
    this.doInput = true
    this.outputStream.writeBytes(body.bytes)
}

internal fun HttpURLConnection.toResponseCode(): ResponseCode {
    return when(responseCode) {
        ResponseCode.HTTP_OK.code -> ResponseCode.HTTP_OK
        ResponseCode.HTTP_CREATED.code -> ResponseCode.HTTP_CREATED
        ResponseCode.HTTP_ACCEPTED.code -> ResponseCode.HTTP_ACCEPTED
        ResponseCode.HTTP_NOT_AUTHORITATIVE.code -> ResponseCode.HTTP_NOT_AUTHORITATIVE
        ResponseCode.HTTP_NO_CONTENT.code -> ResponseCode.HTTP_NO_CONTENT
        ResponseCode.HTTP_RESET.code -> ResponseCode.HTTP_RESET
        ResponseCode.HTTP_PARTIAL.code -> ResponseCode.HTTP_PARTIAL
        ResponseCode.HTTP_MULTI_CHOICE.code -> ResponseCode.HTTP_MULTI_CHOICE
        ResponseCode.HTTP_MOVED_PERMANENTLY.code -> ResponseCode.HTTP_MOVED_PERMANENTLY
        ResponseCode.HTTP_MOVED_TEMPORARY.code -> ResponseCode.HTTP_MOVED_TEMPORARY
        ResponseCode.HTTP_SEE_OTHER.code -> ResponseCode.HTTP_SEE_OTHER
        ResponseCode.HTTP_NOT_MODIFIED.code -> ResponseCode.HTTP_NOT_MODIFIED
        ResponseCode.HTTP_USE_PROXY.code -> ResponseCode.HTTP_USE_PROXY
        ResponseCode.HTTP_BAD_REQUEST.code -> ResponseCode.HTTP_BAD_REQUEST
        ResponseCode.HTTP_UNAUTHORIZED.code -> ResponseCode.HTTP_UNAUTHORIZED
        ResponseCode.HTTP_PAYMENT_REQUIRED.code -> ResponseCode.HTTP_PAYMENT_REQUIRED
        ResponseCode.HTTP_FORBIDDEN.code -> ResponseCode.HTTP_FORBIDDEN
        ResponseCode.HTTP_NOT_FOUND.code -> ResponseCode.HTTP_NOT_FOUND
        ResponseCode.HTTP_BAD_METHOD.code -> ResponseCode.HTTP_BAD_METHOD
        ResponseCode.HTTP_NOT_ACCEPTABLE.code -> ResponseCode.HTTP_NOT_ACCEPTABLE
        ResponseCode.HTTP_PROXY_AUTH.code -> ResponseCode.HTTP_PROXY_AUTH
        ResponseCode.HTTP_CLIENT_TIMEOUT.code -> ResponseCode.HTTP_CLIENT_TIMEOUT
        ResponseCode.HTTP_CONFLICT.code -> ResponseCode.HTTP_CONFLICT
        ResponseCode.HTTP_GONE.code -> ResponseCode.HTTP_GONE
        ResponseCode.HTTP_LENGTH_REQUIRED.code -> ResponseCode.HTTP_LENGTH_REQUIRED
        ResponseCode.HTTP_PRECONDITION_FAILED.code -> ResponseCode.HTTP_PRECONDITION_FAILED
        ResponseCode.HTTP_ENTITY_TOO_LARGE.code -> ResponseCode.HTTP_ENTITY_TOO_LARGE
        ResponseCode.HTTP_REQUEST_TOO_LONG.code -> ResponseCode.HTTP_REQUEST_TOO_LONG
        ResponseCode.HTTP_UNSUPPORTED_MEDIA_TYPE.code -> ResponseCode.HTTP_UNSUPPORTED_MEDIA_TYPE
        ResponseCode.HTTP_INTERNAL_ERROR.code -> ResponseCode.HTTP_INTERNAL_ERROR
        ResponseCode.HTTP_NOT_IMPLEMENTED.code -> ResponseCode.HTTP_NOT_IMPLEMENTED
        ResponseCode.HTTP_BAD_GATEWAY.code -> ResponseCode.HTTP_BAD_GATEWAY
        ResponseCode.HTTP_UNAVAILABLE.code -> ResponseCode.HTTP_UNAVAILABLE
        ResponseCode.HTTP_GATEWAY_TIMEOUT.code -> ResponseCode.HTTP_GATEWAY_TIMEOUT
        ResponseCode.HTTP_VERSION_NOT_SUPPORTED.code -> ResponseCode.HTTP_VERSION_NOT_SUPPORTED
        else -> ResponseCode.HTTP_UNKNOWN
    }
}

internal fun HttpURLConnection.isSuccessCode(): Boolean {
    return this.toResponseCode().isSuccess()
}

internal fun HttpURLConnection.responseBody(): ResponseBody {
    var response: ByteArray
    this.inputStream.apply {
        response = readBytes()
    }.close()
    return ResponseBody(
        response,
        code = toResponseCode()
    )
}
