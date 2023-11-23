package cl.tiocomegfas.lib.core.service

import android.app.Notification
import android.content.Intent

abstract class ForegroundService(
    private val idService: Int
): BaseService() {
    // Notification for show when service is run
    private var notification: Notification? = null

    override fun onCreate() {
        super.onCreate()
        notification = createNotification()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Define service to foreground
        startForeground(idService, notification)
        // Execute logic from BaseService
        return super.onStartCommand(intent, flags, startId)
    }

    abstract fun createNotification(): Notification

    override fun onDestroy() {
        stopForeground(STOP_FOREGROUND_REMOVE)
        super.onDestroy()
    }
}