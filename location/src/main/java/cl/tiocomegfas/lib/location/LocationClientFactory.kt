package cl.tiocomegfas.lib.location

import android.content.Context
import cl.tiocomegfas.lib.location.internal.LocationClientImpl

object LocationClientFactory {
    fun create(
        context: Context
    ): LocationClient {
        return LocationClientImpl(context)
    }
}