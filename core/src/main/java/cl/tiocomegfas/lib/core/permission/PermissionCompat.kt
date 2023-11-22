package cl.tiocomegfas.lib.core.permission

interface PermissionCompat {
    fun isCameraGranted(): Boolean
    fun isLocationGranted(): Boolean
    fun isBluetoothGranted(): Boolean
    fun isNotificationGranted(): Boolean
    fun isStorageGranted(): Boolean
}