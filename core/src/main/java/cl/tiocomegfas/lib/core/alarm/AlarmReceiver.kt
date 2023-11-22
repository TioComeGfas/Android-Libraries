package cl.tiocomegfas.lib.core.alarm

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

abstract class AlarmReceiver: BroadcastReceiver() {
    protected fun isServiceRunningInForeground(context: Context, serviceClass: KClass<*>): Boolean {
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.java.name == service.service.className && service.foreground) {
                return true
            }
        }
        return false
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent == null) return
        if(context == null) return
        try {
            execute(context, intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    abstract fun execute(context: Context, intent: Intent)
}