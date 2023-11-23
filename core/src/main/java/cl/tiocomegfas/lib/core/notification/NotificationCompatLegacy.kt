package cl.tiocomegfas.lib.core.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

internal class NotificationCompatLegacy(context: Context): BaseNotificationCompat(context) {
    override fun createForegroundServiceNotification(
        @DrawableRes icon: Int,
        title: String,
        description: String
    ): Notification {
        return NotificationCompat.Builder(context)
            .setContentTitle(title)
            .setSmallIcon(icon)
            .setOngoing(true)
            .setContentText(description)
            .build()
    }

    override fun createSimpleNotification(
        channelId: String,
        channelName: String,
        icon: Int,
        title: String,
        description: String
    ): Notification {
        return NotificationCompat.Builder(context)
            .setContentTitle(title)
            .setSmallIcon(icon)
            .setContentText(description)
            .build()
    }
}