package cl.tiocomegfas.lib.network.internal.util

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import java.io.OutputStream

internal fun Bitmap?.jpegToStream(quality: Int): ByteArray {
    val bos = ByteArrayOutputStream()
    this?.compress(Bitmap.CompressFormat.JPEG, quality, bos)
    return bos.toByteArray()
}

internal fun Bitmap?.pngToStream(quality: Int): ByteArray {
    val bos = ByteArrayOutputStream()
    this?.compress(Bitmap.CompressFormat.PNG, quality, bos)
    return bos.toByteArray()
}