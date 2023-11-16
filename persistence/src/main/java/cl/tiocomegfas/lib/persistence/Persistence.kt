package cl.tiocomegfas.lib.persistence

interface Persistence {
    suspend fun <T> write(key: String, value: T)
    suspend fun <T> read(key: String, default: T): T
    suspend fun <T> all(): List<T>
    suspend fun contains(key: String): Boolean
    suspend fun clear()
    suspend fun remove(key: String)
}