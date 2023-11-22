package cl.tiocomegfas.lib.network.internal.shared.mediatype

import cl.tiocomegfas.lib.network.MediaType

internal class TextPlainMediaType: MediaType() {
    override val type: String
        get() = "text"
    override val subtype: String
        get() = "plain"
}