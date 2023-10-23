package cl.tiocomegfas.lib.bluetooth

import android.content.Context
import cl.tiocomegfas.lib.bluetooth.internal.ble.BLEClient

object BluetoothFactory {

    fun getBluetoothLowEnergy(
        context: Context
    ): BluetoothClient {
        return BLEClient(context)
    }
}