@file:SuppressLint("MissingPermission")
package cl.tiocomegfas.lib.bluetooth.internal.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.ScanCallback
import android.content.Context
import androidx.core.content.getSystemService
import cl.tiocomegfas.lib.bluetooth.BluetoothClient
import cl.tiocomegfas.lib.bluetooth.DeviceBluetooth
import cl.tiocomegfas.lib.bluetooth.internal.PermissionChecker
import cl.tiocomegfas.lib.bluetooth.internal.util.math.BluetoothMath
import cl.tiocomegfas.lib.bluetooth.internal.util.math.BluetoothMathImpl
import kotlinx.coroutines.delay

internal class BluetoothLowEnergyClient(
    private val context: Context
): BluetoothClient {
    private var manager: BluetoothManager? = null
    private var adapter: BluetoothAdapter? = null
    private var devices: MutableList<DeviceBluetooth> = mutableListOf()
    private var scanCallback: ScanCallback? = null
    private var math: BluetoothMath? = null
    private var permissionChecker: PermissionChecker? = null
    private var time: Long = 0

    override fun initialize() {
        this.permissionChecker = PermissionChecker(context)
        this.manager = context.getSystemService<BluetoothManager>()
        this.adapter = manager?.adapter
        this.devices = mutableListOf()
        this.math = BluetoothMathImpl()
        this.time = 0
        this.scanCallback = BluetoothLowEnergyScanCallback(math!!) { device -> this.devices.add(device) }
    }

    override suspend fun scan(timeout: Long): List<DeviceBluetooth> {
        checkPermissions()
        time = 0
        devices = mutableListOf()
        adapter?.bluetoothLeScanner?.startScan(scanCallback)
        while (time < timeout) {
            delay(1000)
            time++
        }
        adapter?.bluetoothLeScanner?.stopScan(scanCallback)
        return devices
    }

    override suspend fun stop() {
        checkPermissions()
        adapter?.bluetoothLeScanner?.stopScan(scanCallback)
        time = 0
    }

    override suspend fun connect(device: DeviceBluetooth): Boolean {
        return false
    }

    override fun release() {
        this.manager = null
        this.devices = mutableListOf()
        this.adapter = null
        this.scanCallback = null
        this.permissionChecker = null
        time = 0
    }

    private fun checkPermissions() {
        permissionChecker?.checkBluetoothScanPermission()
        permissionChecker?.checkBluetoothConnectPermission()
        permissionChecker?.checkAccessFineLocationPermission()
    }
}