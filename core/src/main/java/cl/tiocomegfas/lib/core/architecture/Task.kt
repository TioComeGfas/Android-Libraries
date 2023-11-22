package cl.tiocomegfas.lib.core.architecture

interface Task<Request, Response> {
    fun execute(request: Request): Response
}