package cl.tiocomegfas.lib.core.factory

interface Provider<T> {
    fun get(): T
}