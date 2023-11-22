package cl.tiocomegfas.lib.core.architecture

import androidx.annotation.RestrictTo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext

abstract class UnitUseCase(
    private val dispatcher: CoroutineDispatcher
): BaseUseCase<Unit, Unit, Unit>() {
    private var onSuccess: (suspend (ResourceState.Success<Unit>) -> Unit)? = {}
    private var onFailure: (suspend (ResourceState.Error<Unit>) -> Unit)? = {}
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override suspend fun invoke(request: Unit) {
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

    override suspend fun onSuccess(callback: suspend (ResourceState.Success<Unit>) -> Unit): UseCase<Unit,Unit,Unit> {
        onSuccess = callback
        return this
    }

    override suspend fun onFailure(callback: suspend (ResourceState.Error<Unit>) -> Unit): UseCase<Unit,Unit,Unit> {
        onFailure = callback
        return this
    }

    override suspend fun execute() {
        this.invoke(Unit)
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override suspend fun dispose() {
        dispatcher.cancel()
        onFailure = null
        onSuccess = null
    }
}