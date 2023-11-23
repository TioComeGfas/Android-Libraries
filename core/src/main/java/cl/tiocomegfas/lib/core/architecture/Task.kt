package cl.tiocomegfas.lib.core.architecture

interface Task<Request, Response> {
    suspend fun execute(request: Request): Response
}