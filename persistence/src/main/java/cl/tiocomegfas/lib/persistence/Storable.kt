package cl.tiocomegfas.lib.persistence

interface Storable {
    fun fromJson(data: String): Storable
    fun toJson(): String
}