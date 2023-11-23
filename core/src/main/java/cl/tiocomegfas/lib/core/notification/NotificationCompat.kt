package cl.tiocomegfas.lib.core.notification

import android.app.Notification
import androidx.annotation.DrawableRes

interface NotificationCompat {
    fun createForegroundServiceNotification(
        @DrawableRes icon: Int,
        title: String,
        description: String
    ): Notification

    fun createSimpleNotification(
        channelId: String,
        channelName: String,
        @DrawableRes icon: Int,
        title: String,
        description: String
    ): Notification
}