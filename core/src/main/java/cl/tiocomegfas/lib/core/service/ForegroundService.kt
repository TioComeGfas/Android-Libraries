package cl.tiocomegfas.lib.core.service

import android.app.ForegroundServiceStartNotAllowedException
import android.app.Notification
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) startForegroundAPI31()
        else startForeground(idService, notification)
        // Execute logic from BaseService
        return super.onStartCommand(intent, flags, startId)
    }

    abstract fun createNotification(): Notification

    @RequiresApi(Build.VERSION_CODES.S)
    private fun startForegroundAPI31() {
        try {
            startForeground(idService, notification)
        } catch (e: ForegroundServiceStartNotAllowedException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        stopForeground(STOP_FOREGROUND_REMOVE)
        super.onDestroy()
    }
}