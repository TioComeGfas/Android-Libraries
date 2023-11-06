package cl.tiocomegfas.lib.network.compiler

import cl.tiocomegfas.lib.network.annotation.Https
import cl.tiocomegfas.lib.network.compiler.internal.findAnnotation
import cl.tiocomegfas.lib.network.compiler.internal.isGetAnnotation
import cl.tiocomegfas.lib.network.compiler.internal.isPostAnnotation
import com.google.devtools.ksp.getDeclaredFunctions
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

abstract class NetworkCompilerProcessor: SymbolProcessor {
    protected var url: String = ""

    override fun process(resolver: Resolver): List<KSAnnotated> {
        if(resolver.findAnnotation(Https::class.java) != null) {

        }


        val protocol = if(resolver.)
        val networkAnnotation = resolver.findNetworkAnnotation().baseUrl
        val functions = resolver.getClassWithNetworkAnnotation().getDeclaredFunctions()

        functions.forEachIndexed { _, function ->
            // use get method
            if(function.isGetAnnotation()) useGetMethod(function)
            // use post method
            if(function.isPostAnnotation()) usePostMethod(function)
        }
    }

    abstract fun useHttps(annotation: Https) {

    }

    abstract fun useGetMethod(function: KSFunctionDeclaration)
    abstract fun usePostMethod(function: KSFunctionDeclaration)
}