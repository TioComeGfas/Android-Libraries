@file:SuppressLint("MissingPermission")
package cl.tiocomegfas.lib.bluetooth.internal.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import cl.tiocomegfas.lib.bluetooth.internal.Scanner

class BleScanner(
    private val adapter: BluetoothAdapter
): ScanCallback(), Scanner {
    private var devices: List<BluetoothDevice> = emptyList()

    override suspend fun start() {
        devices = emptyList()
        adapter.bluetoothLeScanner.startScan(this)
    }

    override suspend fun stop() {
        adapter.bluetoothLeScanner.stopScan(this)
    }

    override suspend fun getDevices(): List<BluetoothDevice> {
        val result: MutableList<BluetoothDevice> = mutableListOf()
        devices
            .groupBy { it.address }.values
            .forEachIndexed { _, bluetoothDevices ->
                result.add(bluetoothDevices.first())
            }
        return result
    }

    override fun onScanResult(callbackType: Int, result: ScanResult?) {
        super.onScanResult(callbackType, result)
        result?.let { scan ->
            devices = devices.plus(scan.device)
        }
    }

    override fun onBatchScanResults(results: MutableList<ScanResult>?) {
        super.onBatchScanResults(results)
        results?.let { scan ->
            scan.forEachIndexed { _, scanResult ->
                devices = devices.plus(scanResult.device)
            }
        }
    }
}