package cl.tiocomegfas.lib.core.service

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.reflect.KClass

@RequiresApi(Build.VERSION_CODES.O)
internal class ServiceAPI26: ServiceCompat {
    override fun startService(context: Context, serviceClass: KClass<*>) {
        context.startForegroundService(Intent(context, serviceClass.java))
    }

    override fun stopService(context: Context, serviceClass: KClass<*>) {
        context.stopService(Intent(context, serviceClass.java))
    }
}