package cl.tiocomegfas.lib.core.service

import android.content.Context
import kotlin.reflect.KClass

interface ServiceLauncher {
    fun startForeground(context: Context, serviceClass: Class<out ForegroundService>)
    fun startBackground(context: Context, serviceClass: Class<out BackgroundService>)
    fun stopService(context: Context, serviceClass: Class<out BackgroundService>)
}