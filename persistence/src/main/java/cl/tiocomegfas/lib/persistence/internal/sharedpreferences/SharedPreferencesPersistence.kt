package cl.tiocomegfas.lib.persistence.internal.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import cl.tiocomegfas.lib.persistence.Persistence

internal class SharedPreferencesPersistence(
    context: Context,
    name: String
): Persistence {
    private val sharedPreferences: SharedPreferences by lazy { context.getSharedPreferences(name, Context.MODE_PRIVATE) }

    override suspend fun <T> write(key: String, value: T) {
        when(value) {
            is Boolean -> sharedPreferences.writeBoolean(key, value)
            is Byte -> sharedPreferences.writeByte(key, value)
            is Char -> sharedPreferences.writeChar(key, value)
            is Double -> sharedPreferences.writeDouble(key, value)
            is Int -> sharedPreferences.writeInt(key, value)
            is Float -> sharedPreferences.writeFloat(key, value)
            is Long -> sharedPreferences.writeLong(key, value)
            is String -> sharedPreferences.writeString(key, value)
            else -> throw UnsupportedOperationException()
        }
    }

    override suspend fun <T> read(key: String, default: T): T {
        return when(default) {
            is Boolean -> sharedPreferences.readBoolean(key, default) as T
            is Byte -> sharedPreferences.readByte(key, default) as T
            is Char -> sharedPreferences.readChar(key, default) as T
            is Double -> sharedPreferences.readDouble(key, default) as T
            is Int -> sharedPreferences.readInt(key, default) as T
            is Float -> sharedPreferences.readFloat(key, default) as T
            is Long -> sharedPreferences.readLong(key, default) as T
            is String -> sharedPreferences.readString(key, default) as T
            else -> throw UnsupportedOperationException()
        }
    }

    override suspend fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }

    override suspend fun clear() {
        return sharedPreferences.edit().clear().apply()
    }

    override suspend fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

}