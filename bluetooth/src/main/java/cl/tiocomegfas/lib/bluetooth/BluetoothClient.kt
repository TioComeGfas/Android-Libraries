package cl.tiocomegfas.lib.bluetooth

interface BluetoothClient {
    fun initialize()
    suspend fun scan(timeout: Long): List<DeviceBluetooth>
    suspend fun stop()
    suspend fun connect(device: DeviceBluetooth): Boolean
    fun release()
}