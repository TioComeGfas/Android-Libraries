package cl.tiocomegfas.lib.core.architecture

sealed class ResourceState<T> {
    data class Success<T>(val data: T): ResourceState<T>()
    data class Error<T>(val error: Throwable): ResourceState<T>()
    data class Loading<T>(val message: String = "Cargando"): ResourceState<T>()
}