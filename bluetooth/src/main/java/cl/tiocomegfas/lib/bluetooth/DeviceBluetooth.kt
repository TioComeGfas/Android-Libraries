package cl.tiocomegfas.lib.bluetooth

data class DeviceBluetooth(
    val name: String,
    val rssi: Int,
    val distance: Double,
    val mac: String
)
