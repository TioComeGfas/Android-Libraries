package cl.tiocomegfas.lib.network.internal.shared.mediatype

import cl.tiocomegfas.lib.network.MediaType

class ImagePngMediaType: MediaType() {
    override val type: String
        get() = "image"
    override val subtype: String
        get() = "png"
}