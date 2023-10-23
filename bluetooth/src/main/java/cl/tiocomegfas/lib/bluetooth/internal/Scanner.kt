package cl.tiocomegfas.lib.bluetooth.internal

import android.bluetooth.BluetoothDevice

interface Scanner {
    suspend fun start()
    suspend fun stop()
    suspend fun getDevices(): List<BluetoothDevice>
}