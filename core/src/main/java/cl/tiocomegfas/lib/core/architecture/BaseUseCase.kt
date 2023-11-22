package cl.tiocomegfas.lib.core.architecture

abstract class BaseUseCase<in Request, Response, out Mapped>: UseCase<Request, Response, Mapped> {
    protected abstract suspend fun invoke(request: Request)
    protected abstract suspend fun onRequestHandler(request: Request): Response
    protected abstract suspend fun onResponseHandler(response: Response): Mapped
    protected abstract suspend fun onErrorHandler(cause: Throwable): Throwable
    protected abstract suspend fun dispose()
}