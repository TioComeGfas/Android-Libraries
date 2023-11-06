package cl.tiocomegfas.lib.network.compiler.internal

import cl.tiocomegfas.lib.network.compiler.NetworkCompilerProcessor
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

internal class NetworkCompilerProcessorImpl: NetworkCompilerProcessor() {

    override fun useGetMethod(function: KSFunctionDeclaration) {
        function.parameters.forEach { parameter ->
            // validate if use url in request
            if(parameter.isUrlAnnotation()) {
                val urlAnnotation = parameter.getUrlAnnotation()
                urlAnnotation.value
            }

            // validate if use query in request
            if(parameter.isQueryAnnotation()) {
                val queryAnnotation = parameter.getQueryAnnotation()
            }

            // validate if use header in request
            if(parameter.isHeaderAnnotation()) {
                val headerAnnotation = parameter.getHeaderAnnotation()
            }
        }
    }

    override fun usePostMethod(function: KSFunctionDeclaration) {
        TODO("Not yet implemented")
    }
}