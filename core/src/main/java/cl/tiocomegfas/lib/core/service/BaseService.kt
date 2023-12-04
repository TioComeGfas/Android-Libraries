package cl.tiocomegfas.lib.core.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.annotation.RestrictTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

abstract class BaseService: Service() {
    // Thread in the work service
    protected var thread: ExecutorService? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        thread = Executors.newFixedThreadPool(1)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Create thread for work in service
        try {
            thread?.execute {
                runBlocking {
                    onStartWork()
                    stopSelf()
                }
            }
        } catch (e: InterruptedException) {
            thread?.shutdownNow()
            Thread.currentThread().interrupt()
        }
        // Return don't relaunch service when SO kill
        return START_NOT_STICKY
    }

    abstract suspend fun onStartWork()

    override fun onDestroy() {
        super.onDestroy()
        thread?.shutdown()
    }
}