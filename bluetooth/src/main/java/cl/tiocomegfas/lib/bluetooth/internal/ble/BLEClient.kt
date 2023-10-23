@file:SuppressLint("MissingPermission")
package cl.tiocomegfas.lib.bluetooth.internal.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import cl.tiocomegfas.lib.bluetooth.BluetoothClient
import cl.tiocomegfas.lib.bluetooth.BluetoothState
import cl.tiocomegfas.lib.bluetooth.internal.Scanner
import kotlinx.coroutines.delay

internal class BLEClient(
    private val context: Context
): BluetoothClient {
    private var manager: BluetoothManager? = null
    private var scanner: Scanner? = null
    private var gatt: BleGatt? = null
    private var state: BluetoothState = BluetoothState.STATE_DISCONNECTED

    override fun initialize() {
        context.getSystemService(BluetoothManager::class.java).also {
            manager = it
            scanner = BleScanner(it.adapter)
            gatt = BleGatt()
        }
    }

    override suspend fun scan(time: Long): List<BluetoothDevice> {
        scanner?.start()
        delay(time)
        scanner?.stop()
        return scanner?.getDevices() ?: emptyList()
    }

    override suspend fun connect(device: BluetoothDevice): Boolean {
        val connection = device.connectGatt(context,false, gatt)

        return true
        //connection.readCharacteristic()
    }

    override fun release() {
        manager = null
        scanner = null
    }
}