package cl.tiocomegfas.lib.core.alarm

import android.content.Context

object AlarmFactory {
    fun create(context: Context): AlarmCompat {
        return AlarmCompatImpl(context)
    }
}