package cl.tiocomegfas.lib.core.service

import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

internal class ServiceLauncherLegacy: ServiceLauncher {
    override fun <T : ForegroundService> startForeground(
        context: Context,
        serviceClass: KClass<T>
    ) {
        context.startService(Intent(context, serviceClass.java))
    }

    override fun <T : BackgroundService> startBackground(
        context: Context,
        serviceClass: KClass<T>
    ) {
        context.startService(Intent(context, serviceClass.java))
    }

    override fun <T : BackgroundService> stopService(context: Context, serviceClass: KClass<T>) {
        context.stopService(Intent(context, serviceClass.java))
    }


}