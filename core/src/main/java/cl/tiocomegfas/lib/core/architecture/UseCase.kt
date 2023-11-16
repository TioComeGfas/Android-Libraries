package cl.tiocomegfas.lib.core.architecture

import kotlinx.coroutines.flow.Flow

interface UseCase<in Request, Response, out Mapped> {
    suspend fun invoke(request: Request)
    suspend fun onRequestHandler(request: Request): Response
    suspend fun onResponseHandler(response: Response): Mapped
    suspend fun onErrorHandler(cause: Throwable): Mapped
    suspend fun dispose()
}