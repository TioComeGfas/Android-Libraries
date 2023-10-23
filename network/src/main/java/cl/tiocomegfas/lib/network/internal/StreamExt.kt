package cl.tiocomegfas.lib.network.internal

import java.io.OutputStream
import java.util.stream.Stream

internal fun OutputStream.writeBytes(bytes: ByteArray?) {
    if(bytes == null) return
    write(bytes)
    flush()
    close()
}