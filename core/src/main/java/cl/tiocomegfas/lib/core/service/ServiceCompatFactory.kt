package cl.tiocomegfas.lib.core.service

import android.os.Build

object ServiceCompatFactory {
    fun create(): ServiceCompat {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) ServiceAPI26()
        else ServiceLegacy()
    }
}