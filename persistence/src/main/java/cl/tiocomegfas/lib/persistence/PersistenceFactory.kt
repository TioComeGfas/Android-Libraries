package cl.tiocomegfas.lib.persistence

import android.content.Context
import cl.tiocomegfas.lib.persistence.internal.sharedpreferences.SharedPreferencesPersistence

object PersistenceFactory {
    fun createSharedPreferences(
        context: Context,
        name: String
    ): Persistence {
        return SharedPreferencesPersistence(context, name)
    }

    fun createProtoDataStore(
        context: Context,
        name: String
    ): Persistence {
        TODO("")
    }
}