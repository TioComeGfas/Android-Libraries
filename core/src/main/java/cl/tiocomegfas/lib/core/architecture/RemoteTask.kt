package cl.tiocomegfas.lib.core.architecture

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import org.json.JSONArray
import org.json.JSONObject

abstract class RemoteTask<Request, Response>: Task<Request, Response> {
    protected suspend fun getJsonObject(bytes: ByteArray): JSONObject {
        val chain = String(bytes)
        return JSONObject(chain)
    }
    protected suspend fun getJsonArray(bytes: ByteArray, isArray: Boolean): JSONArray {
        val chain = String(bytes)
        return JSONArray(chain)
    }

    protected suspend fun getImage(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}