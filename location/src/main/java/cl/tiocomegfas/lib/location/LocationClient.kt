package cl.tiocomegfas.lib.location

import kotlin.jvm.Throws

interface LocationClient {
    fun initialize(configuration: LocationClientConfiguration)
    @Throws(LocationClientNotInitializedException::class)
    suspend fun getLastLocation(): LocationData

    @Throws(LocationClientNotInitializedException::class)
    suspend fun getCurrentLocation(): LocationData
}