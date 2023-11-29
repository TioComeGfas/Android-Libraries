package cl.tiocomegfas.lib.bluetooth.internal

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import cl.tiocomegfas.lib.bluetooth.internal.util.exception.AccessFineLocationPermissionException
import cl.tiocomegfas.lib.bluetooth.internal.util.exception.BluetoothConnectPermissionException
import cl.tiocomegfas.lib.bluetooth.internal.util.exception.BluetoothScanPermissionException

internal class PermissionChecker(
    private val context: Context
) {
    @Throws(BluetoothScanPermissionException::class)
    fun checkBluetoothScanPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) return
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_DENIED) throw BluetoothScanPermissionException()
    }
    @Throws(BluetoothConnectPermissionException::class)
    fun checkBluetoothConnectPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) return
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED) throw BluetoothScanPermissionException()
    }

    @Throws(AccessFineLocationPermissionException::class)
    fun checkAccessFineLocationPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) return
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) throw BluetoothScanPermissionException()
    }
}