package cl.tiocomegfas.lib.bluetooth.internal.util.math

import kotlin.math.pow

internal class BluetoothMathImpl: BluetoothMath {
    override fun calculateDistance(rssi: Int): Double {
        val distance: Double = 10.0
        val measurementPower = -69
        return distance.pow(
            (measurementPower - rssi) / (10 * 2)
        )
    }
}