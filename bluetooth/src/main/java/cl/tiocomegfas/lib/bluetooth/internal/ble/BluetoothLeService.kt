package cl.tiocomegfas.lib.bluetooth.internal.ble

import android.app.Service
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothProfile
import android.content.Intent
import android.os.IBinder
import cl.tiocomegfas.lib.bluetooth.BluetoothState

internal class BluetoothLeService(
    private var bluetoothGatt: BluetoothGatt?
): Service() {
    private var connectionState: BluetoothState = BluetoothState.STATE_DISCONNECTED

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private val gattCallback = object : BluetoothGattCallback() {

    }

}