package cl.tiocomegfas.lib.bluetooth

import android.content.Context
import cl.tiocomegfas.lib.bluetooth.internal.ble.BluetoothLowEnergyClient

object BluetoothFactory {

    fun getBluetoothLowEnergy(
        context: Context
    ): BluetoothClient {
        return BluetoothLowEnergyClient(context)
    }
}