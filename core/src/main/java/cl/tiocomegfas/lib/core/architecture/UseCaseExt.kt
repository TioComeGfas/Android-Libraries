package cl.tiocomegfas.lib.core.architecture

fun <T> UseCase<*,*,*>.createSuccessState(data: T): ResourceState<T> {
    return ResourceState.Success(data)
}

fun <T> UseCase<*,*,*>.createErrorState(data: Throwable): ResourceState<T> {
    return ResourceState.Error<T>(data)
}