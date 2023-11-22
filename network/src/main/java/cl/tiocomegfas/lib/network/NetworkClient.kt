package cl.tiocomegfas.lib.network

import android.graphics.Bitmap
import androidx.annotation.IntRange

interface NetworkClient {
    suspend fun https(
        url: String
    ): NetworkClient

    suspend fun http(
        url: String
    ): NetworkClient

    suspend fun query(
        key: String,
        value: String
    ): NetworkClient

    suspend fun header(
        key: String,
        value: String
    ): NetworkClient

    suspend fun addImageToBody(
        image: Bitmap?,
        @IntRange(from = 0L, to = 100L) quality: Int = 75,
    ): NetworkClient

    suspend fun body(
        data: cl.tiocomegfas.lib.network.internal.shared.request.RequestBody
    ): NetworkClient

    suspend fun post(): NetworkClient

    suspend fun get(): NetworkClient

    suspend fun put(body: RequestBody): NetworkClient

    suspend fun execute(): ResponseBody

}