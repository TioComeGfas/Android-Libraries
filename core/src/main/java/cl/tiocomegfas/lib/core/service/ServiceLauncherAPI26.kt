package cl.tiocomegfas.lib.core.service

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.reflect.KClass

@RequiresApi(Build.VERSION_CODES.O)
internal class ServiceLauncherAPI26: ServiceLauncher {
    override fun startForeground(context: Context, serviceClass: Class<out ForegroundService>) {
        context.startForegroundService(Intent(context, serviceClass))
    }

    override fun startBackground(context: Context, serviceClass: Class<out BackgroundService>) {
        context.startService(Intent(context, serviceClass))
    }

    override fun stopService(context: Context, serviceClass: Class<out BackgroundService>) {
        context.stopService(Intent(context, serviceClass))
    }

}