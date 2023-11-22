package cl.tiocomegfas.lib.network.internal.shared.request

import cl.tiocomegfas.lib.network.MediaType
import java.io.OutputStream
import java.io.PrintWriter

abstract class RequestBody {
    protected var writer: PrintWriter? = null
    abstract fun mediaType(): MediaType?
    open fun contentLength(): Long = -1
    open fun charset(): String = "UTF-8"
    abstract fun writeTo(buffer: OutputStream)
    companion object {
        internal const val LINE_FEED = "\r\n"
    }
}