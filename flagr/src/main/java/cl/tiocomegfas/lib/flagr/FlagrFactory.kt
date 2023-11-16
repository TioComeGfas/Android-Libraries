package cl.tiocomegfas.lib.flagr

import androidx.annotation.XmlRes
import cl.tiocomegfas.lib.flagr.internal.FlagrImpl

object FlagrFactory {
    fun createRemoteConfig(
        @XmlRes default: Int
    ): Flagr {
        return FlagrImpl(default)
    }
}