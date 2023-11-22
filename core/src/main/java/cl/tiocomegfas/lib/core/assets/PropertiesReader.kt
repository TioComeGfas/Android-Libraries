package cl.tiocomegfas.lib.core.assets

interface PropertiesReader {
    fun loadFile(name: String)
    fun readString(key: String, defaultValue: String): String
    fun readInt(key: String, defaultValue: Int): Int
    fun readLong(key: String, defaultValue: Long): Long
    fun readFloat(key: String, defaultValue: Float): Float
    fun readDouble(key: String, defaultValue: Double): Double
    fun readBoolean(key: String, defaultValue: Boolean): Boolean
}