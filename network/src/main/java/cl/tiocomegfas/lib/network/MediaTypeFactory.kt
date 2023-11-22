package cl.tiocomegfas.lib.network

import cl.tiocomegfas.lib.network.internal.shared.mediatype.ImageJpegMediaType
import cl.tiocomegfas.lib.network.internal.shared.mediatype.ImagePngMediaType
import cl.tiocomegfas.lib.network.internal.shared.mediatype.TextPlainMediaType

object MediaTypeFactory {
    fun createTextPlain(): MediaType = TextPlainMediaType()
    fun createImagePng(): MediaType = ImagePngMediaType()
    fun createImageJpeg(): MediaType = ImageJpegMediaType()
}