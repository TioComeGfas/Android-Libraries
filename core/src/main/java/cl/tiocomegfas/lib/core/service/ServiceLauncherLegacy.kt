package cl.tiocomegfas.lib.core.service

import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

internal class ServiceLauncherLegacy: ServiceLauncher {
    override fun startForeground(context: Context, serviceClass: Class<out ForegroundService>) {
        context.startService(Intent(context, serviceClass))
    }

    override fun startBackground(context: Context, serviceClass: Class<out BackgroundService>) {
        context.startService(Intent(context, serviceClass))
    }

    override fun stopService(context: Context, serviceClass: Class<out BackgroundService>) {
        context.stopService(Intent(context, serviceClass))
    }


}