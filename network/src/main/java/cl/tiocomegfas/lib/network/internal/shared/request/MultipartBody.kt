package cl.tiocomegfas.lib.network.internal.shared.request

import cl.tiocomegfas.lib.network.MediaType
import java.io.OutputStream

class MultipartBody: RequestBody() {
    //val parts: List<Part>
    override fun mediaType(): MediaType? {
        TODO("Not yet implemented")
    }

    override fun writeTo(buffer: OutputStream) {
        TODO("Not yet implemented")
    }

}