package cl.tiocomegfas.lib.flagr

interface Flagr {
    fun initialize(onSuccess: () -> Unit)
    fun getBoolean(key: String): Boolean
    fun getDouble(key: String): Double
    fun getLong(key: String): Long
    fun getString(key: String): String
    fun getAll(): List<Pair<String, Any?>>
}