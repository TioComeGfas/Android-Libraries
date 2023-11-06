package cl.tiocomegfas.lib.network.compiler.internal

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration

internal inline fun <reified T> Resolver.findAnnotation(annotation: Class<T>): T? {
    return getSymbolsWithAnnotation(annotation.name)
        .filterIsInstance<T>()
        .firstOrNull()
}

internal fun <T> Resolver.getClassWithAnnotation(annotation: Class<T>): KSClassDeclaration {
    return getSymbolsWithAnnotation(annotation.name) as KSClassDeclaration
}