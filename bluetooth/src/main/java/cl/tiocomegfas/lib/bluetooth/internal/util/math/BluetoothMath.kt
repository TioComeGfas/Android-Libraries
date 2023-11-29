package cl.tiocomegfas.lib.bluetooth.internal.util.math

internal interface BluetoothMath {
    fun calculateDistance(rssi: Int): Double
}