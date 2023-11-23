package cl.tiocomegfas.lib.core.notification

import android.app.NotificationManager
import android.content.Context

internal abstract class BaseNotificationCompat(
    protected val context: Context
): NotificationCompat {
    protected val manager: NotificationManager = context.getSystemService(NotificationManager::class.java)

}