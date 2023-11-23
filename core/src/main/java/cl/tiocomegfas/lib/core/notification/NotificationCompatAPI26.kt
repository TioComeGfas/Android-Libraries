package cl.tiocomegfas.lib.core.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

@RequiresApi(Build.VERSION_CODES.O)
internal class NotificationCompatAPI26(context: Context): BaseNotificationCompat(context) {
    override fun createForegroundServiceNotification(
        @DrawableRes icon: Int,
        title: String,
        description: String
    ): Notification {
        val channelId: String = "update_channel"
        val channel = NotificationChannel(
            channelId,
            "Channel for update local data with remote data",
            NotificationManager.IMPORTANCE_LOW
        )
        manager.createNotificationChannel(channel)

        return NotificationCompat.Builder(context, channelId)
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
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        manager.createNotificationChannel(channel)

        return NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setSmallIcon(icon)
            .setContentText(description)
            .build()
    }
}