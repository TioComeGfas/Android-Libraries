package cl.tiocomegfas.lib.core.service

import android.content.Context
import kotlin.reflect.KClass

interface ServiceLauncher {
    fun <T: ForegroundService> startForeground(context: Context, serviceClass: KClass<T>)
    fun <T: BackgroundService> startBackground(context: Context, serviceClass: KClass<T>)
    fun <T: BackgroundService> stopService(context: Context, serviceClass: KClass<T>)
}