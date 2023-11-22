package cl.tiocomegfas.lib.core.assets

import android.content.Context

object PropertiesReaderFactory {
    fun create(
        context: Context
    ): PropertiesReader {
        return PropertiesReaderImpl(context)
    }
}