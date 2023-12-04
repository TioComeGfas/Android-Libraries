package cl.tiocomegfas.lib.location

import com.google.android.gms.location.CurrentLocationRequest
import com.google.android.gms.location.LocationRequest

class LocationClientConfiguration private constructor(
    private var interval: Long,
    private var priority: Priority
) {


    internal fun getRequest(): CurrentLocationRequest {
        return CurrentLocationRequest
            .Builder()
            .setDurationMillis(interval)
            .setPriority(priority.value)
            .build()
    }

    class Builder {
        private var interval: Long = 10000
        private var minDistanceForUpdate: Float = 1f
        private var priority: Priority = Priority.HIGH_ACCURACY

        fun setInterval(valueInMillis: Long): Builder {
            this.interval = valueInMillis
            return this
        }
        fun setPriority(value: Priority): Builder {
            this.priority = value
            return this
        }

        fun build(): LocationClientConfiguration {
            return LocationClientConfiguration(
                interval = interval,
                priority = priority
            )
        }
    }
}