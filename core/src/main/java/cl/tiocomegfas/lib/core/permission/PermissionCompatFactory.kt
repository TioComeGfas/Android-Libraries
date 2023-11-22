package cl.tiocomegfas.lib.core.permission

import android.content.Context

object PermissionCompatFactory {
    fun create(
        context: Context
    ): PermissionCompat {
        return PermissionCompatImpl(context)
    }
}