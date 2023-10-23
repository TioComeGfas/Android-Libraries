package cl.tiocomegfas.lib.bluetooth

import android.bluetooth.BluetoothDevice

interface BluetoothClient {
    fun initialize()
    suspend fun scan(time: Long): List<BluetoothDevice>
    suspend fun connect(device: BluetoothDevice): Boolean
    fun release()
}