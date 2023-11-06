package cl.tiocomegfas.lib.network

interface NetworkConfigurable {
    fun baseUrl(): String
    fun timeout(): String
    fun port(): String
}