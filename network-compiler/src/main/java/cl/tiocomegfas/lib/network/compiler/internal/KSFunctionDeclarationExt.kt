package cl.tiocomegfas.lib.network.compiler.internal

import cl.tiocomegfas.lib.network.annotation.GET
import cl.tiocomegfas.lib.network.annotation.POST
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

internal fun KSFunctionDeclaration.isGetAnnotation(): Boolean {
    return this.annotations.firstOrNull {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == GET::javaClass.name
    } != null
}

internal fun KSFunctionDeclaration.isPostAnnotation(): Boolean {
    return this.annotations.firstOrNull {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == POST::javaClass.name
    } != null
}