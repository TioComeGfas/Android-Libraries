package cl.tiocomegfas.lib.core.permission

interface TextPermissionProvider {
    fun getTitle(): String
    fun getPermanentlyDeclined(): String
}