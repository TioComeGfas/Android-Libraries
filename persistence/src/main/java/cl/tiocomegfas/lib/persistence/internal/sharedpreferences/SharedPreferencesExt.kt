package cl.tiocomegfas.lib.persistence.internal.sharedpreferences

import android.content.SharedPreferences

internal fun SharedPreferences.readBoolean(key: String, default: Boolean): Boolean {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_BOOLEAN, "")
        ?.toBoolean()
        ?: default
}
internal fun SharedPreferences.readByte(key: String, default: Byte): Byte {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_BYTE, "")
        ?.toByte()
        ?: default
}
internal fun SharedPreferences.readChar(key: String, default: Char): Char {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_CHAR, "")
        ?.get(0)
        ?: default
}
internal fun SharedPreferences.readDouble(key: String, default: Double): Double {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_DOUBLE, "")
        ?.toDouble()
        ?: default
}
internal fun SharedPreferences.readInt(key: String, default: Int): Int {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_INT, "")
        ?.toInt()
        ?: default
}
internal fun SharedPreferences.readFloat(key: String, default: Float): Float {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_FLOAT, "")
        ?.toFloat()
        ?: default
}
internal fun SharedPreferences.readLong(key: String, default: Long): Long {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_LONG, "")
        ?.toLong()
        ?: default
}
internal fun SharedPreferences.readString(key: String, default: String): String {
    return getString(key, null)
        ?.replace(SharedPreferencesConstants.KEY_STRING, "")
        ?: default
}

internal fun SharedPreferences.writeBoolean(key: String, value: Boolean) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_BOOLEAN).append(value) }
        )
    }.apply()
}
internal fun SharedPreferences.writeByte(key: String, value: Byte) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_BYTE).append(value) }
        )
    }.apply()
}
internal fun SharedPreferences.writeChar(key: String, value: Char) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_CHAR).append(value) }
        )
    }.apply()
}
internal fun SharedPreferences.writeDouble(key: String, value: Double) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_DOUBLE).append(value) }
        )
    }.apply()
}
internal fun SharedPreferences.writeInt(key: String, value: Int) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_INT).append(value) }
        )
    }.apply()
}
internal fun SharedPreferences.writeFloat(key: String, value: Float) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_FLOAT).append(value) }
        )
    }.apply()
}
internal fun SharedPreferences.writeLong(key: String, value: Long) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_LONG).append(value) }
        )
    }.apply()
}
internal fun SharedPreferences.writeString(key: String, value: String) {
    this.edit().also {
        it.putString(
            key,
            buildString { append(SharedPreferencesConstants.KEY_STRING).append(value) }
        )
    }.apply()
}