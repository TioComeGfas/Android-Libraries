package cl.tiocomegfas.lib.core.architecture

import androidx.annotation.RestrictTo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext

abstract class SimpleUseCase<in Request, Mapped>(
    private val dispatcher: CoroutineDispatcher
): BaseUseCase<Request, Mapped, Mapped>() {
    private var params: Request? = null
    private var onSuccess: (suspend (ResourceState.Success<@UnsafeVariance Mapped>) -> Unit)? = {}
    private var onFailure: (suspend (ResourceState.Error<@UnsafeVariance Mapped>) -> Unit)? = {}

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override suspend operator fun invoke(request: Request) {
        withContext(dispatcher) {
            runCatching {
                onResponseHandler(onRequestHandler(request))
            }.onSuccess {
                onSuccess?.invoke(ResourceState.Success(it))
                dispose()
            }.onFailure {
                it.printStackTrace()
                onFailure?.invoke(ResourceState.Error(it))
                dispose()
            }
        }
    }

    override suspend fun setParams(params: Request): UseCase<@UnsafeVariance Request, @UnsafeVariance Mapped, @UnsafeVariance Mapped> {
        this.params = params
        return this
    }

    override suspend fun onSuccess(callback: suspend (ResourceState.Success<@UnsafeVariance Mapped>) -> Unit): UseCase<@UnsafeVariance Request, @UnsafeVariance Mapped, @UnsafeVariance Mapped> {
        onSuccess = callback
        return this
    }

    override suspend fun onFailure(callback: suspend (ResourceState.Error<@UnsafeVariance Mapped>) -> Unit): UseCase<@UnsafeVariance Request, @UnsafeVariance Mapped, @UnsafeVariance Mapped> {
        onFailure = callback
        return this
    }

    override suspend fun execute() {
        params?.let {
            this.invoke(it)
        }?: onFailure { throw IllegalArgumentException("The params for base use case is null") }
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override suspend fun dispose() {
        dispatcher.cancel()
        onSuccess = null
        onFailure = null
    }
}