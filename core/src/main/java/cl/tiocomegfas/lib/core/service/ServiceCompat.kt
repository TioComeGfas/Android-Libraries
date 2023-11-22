package cl.tiocomegfas.lib.core.service

import android.content.Context
import kotlin.reflect.KClass

interface ServiceCompat {
    fun startService(context: Context, serviceClass: KClass<*>)
    fun stopService(context: Context, serviceClass: KClass<*>)
}