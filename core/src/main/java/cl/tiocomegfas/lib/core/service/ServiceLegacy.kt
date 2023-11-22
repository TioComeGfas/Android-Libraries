package cl.tiocomegfas.lib.core.service

import android.content.Context
import android.content.Intent
import cl.tiocomegfas.lib.core.service.ServiceCompat
import kotlin.reflect.KClass

internal class ServiceLegacy: ServiceCompat {
    override fun startService(context: Context, serviceClass: KClass<*>) {
        context.startService(Intent(context, serviceClass.java))
    }

    override fun stopService(context: Context, serviceClass: KClass<*>) {
        context.stopService(Intent(context, serviceClass.java))
    }
}