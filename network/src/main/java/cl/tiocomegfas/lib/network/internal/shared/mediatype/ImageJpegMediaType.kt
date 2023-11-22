package cl.tiocomegfas.lib.network.internal.shared.mediatype

import cl.tiocomegfas.lib.network.MediaType

class ImageJpegMediaType: MediaType() {
    override val type: String
        get() = "image"
    override val subtype: String
        get() = "jpeg"
}