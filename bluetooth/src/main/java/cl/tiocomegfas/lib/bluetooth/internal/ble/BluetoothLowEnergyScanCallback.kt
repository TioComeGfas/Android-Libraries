@file:SuppressLint("MissingPermission")
package cl.tiocomegfas.lib.bluetooth.internal.ble

import android.annotation.SuppressLint
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import cl.tiocomegfas.lib.bluetooth.DeviceBluetooth
import cl.tiocomegfas.lib.bluetooth.internal.util.math.BluetoothMath

internal class BluetoothLowEnergyScanCallback(
    private val math: BluetoothMath?,
    private val onFindDeviceBluetooth: (DeviceBluetooth) -> Unit
): ScanCallback() {

    override fun onScanResult(callbackType: Int, result: ScanResult?) {
        result ?: return
        onFindDeviceBluetooth.invoke(
            DeviceBluetooth(
                name = result.device.name ?: "UNKNOWN",
                rssi = result.rssi,
                distance = math?.calculateDistance(result.rssi) ?: 0.0,
                mac = result.device.address
            )
        )
    }

    override fun onBatchScanResults(results: MutableList<ScanResult>?) {
        results ?: return
        results.forEach { result ->
            onFindDeviceBluetooth.invoke(
                DeviceBluetooth(
                    name = result.device.name ?: "UNKNOWN",
                    rssi = result.rssi,
                    distance = math?.calculateDistance(result.rssi) ?: 0.0,
                    mac = result.device.address
                )
            )
        }
    }
}