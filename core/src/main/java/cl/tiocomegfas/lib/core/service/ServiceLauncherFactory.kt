package cl.tiocomegfas.lib.core.service

import android.os.Build

object ServiceLauncherFactory {
    fun create(): ServiceLauncher {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) ServiceLauncherAPI26()
        else ServiceLauncherLegacy()
    }
}