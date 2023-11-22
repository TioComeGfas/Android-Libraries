package cl.tiocomegfas.lib.core.architecture

interface UseCase<in Request, Response, out Mapped> {
    suspend fun setParams(params: Request): UseCase<@UnsafeVariance Request, @UnsafeVariance Response, @UnsafeVariance Mapped>
    suspend fun onSuccess(callback: suspend (ResourceState.Success<@UnsafeVariance Mapped>) -> Unit): UseCase<@UnsafeVariance Request, @UnsafeVariance Response, @UnsafeVariance Mapped>
    suspend fun onFailure(callback: suspend (ResourceState.Error<@UnsafeVariance Mapped>) -> Unit): UseCase<@UnsafeVariance Request, @UnsafeVariance Response, @UnsafeVariance Mapped>
    suspend fun execute()
}