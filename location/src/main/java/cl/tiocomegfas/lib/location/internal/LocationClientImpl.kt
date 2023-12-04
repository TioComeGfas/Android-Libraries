@file:SuppressLint("MissingPermission")
package cl.tiocomegfas.lib.location.internal

import android.annotation.SuppressLint
import android.content.Context
import cl.tiocomegfas.lib.location.LocationClient
import cl.tiocomegfas.lib.location.LocationClientConfiguration
import cl.tiocomegfas.lib.location.LocationClientNotInitializedException
import cl.tiocomegfas.lib.location.LocationData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.delay

internal class LocationClientImpl(
    private val context: Context
): LocationClient {
    private var client: FusedLocationProviderClient? = null
    private var configuration: LocationClientConfiguration? = null
    override fun initialize(
        configuration: LocationClientConfiguration
    ) {
        this.client = LocationServices.getFusedLocationProviderClient(context)
        this.configuration = configuration
    }

    override suspend fun getLastLocation(): LocationData {
        if(client == null) throw LocationClientNotInitializedException()
        var isCompleted: Boolean = false
        var result = LocationData(0.0,0.0)
        client
        ?.lastLocation
        ?.addOnSuccessListener {
            result = LocationData(
                latitude = it.latitude,
                longitude = it.longitude
            )
            isCompleted = true
        }
        ?.addOnFailureListener {
            isCompleted = true
        }
        ?.addOnCanceledListener {
            isCompleted = true
        }

        // Only used for wait one result
        while(!isCompleted) {
            delay(1000)
        }

        return result
    }

    override suspend fun getCurrentLocation(): LocationData {
        if(client == null) throw LocationClientNotInitializedException()
        if(configuration == null)  throw LocationClientNotInitializedException()
        var isCompleted: Boolean = false
        var result = LocationData(0.0,0.0)
        client
            ?.getCurrentLocation(configuration!!.getRequest(), null)
            ?.addOnSuccessListener {
                result = LocationData(
                    latitude = it.latitude,
                    longitude = it.longitude
                )
                isCompleted = true
            }
            ?.addOnFailureListener {
                isCompleted = true
            }
            ?.addOnCanceledListener {
                isCompleted = true
            }

        // Only used for wait one result
        while(!isCompleted) {
            delay(1000)
        }

        return result
    }
}