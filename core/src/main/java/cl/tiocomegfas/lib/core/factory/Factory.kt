package cl.tiocomegfas.lib.core.factory

interface Factory<T>: Provider<T> {
    fun create(): T?
}