package cl.tiocomegfas.lib.network.internal.shared.multipart

import cl.tiocomegfas.lib.network.MultiPart
import java.io.OutputStream

internal class TextPlainMultiPart(
    val stream: OutputStream,
): MultiPart {

    override fun write(key: String, value: String) {

    }

}