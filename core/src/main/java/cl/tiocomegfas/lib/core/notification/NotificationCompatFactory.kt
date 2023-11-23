package cl.tiocomegfas.lib.core.notification

import android.content.Context
import android.os.Build

object NotificationCompatFactory {
    fun create(
        context: Context
    ): NotificationCompat {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationCompatAPI26(context)
        } else {
            NotificationCompatLegacy(context)
        }
    }
}