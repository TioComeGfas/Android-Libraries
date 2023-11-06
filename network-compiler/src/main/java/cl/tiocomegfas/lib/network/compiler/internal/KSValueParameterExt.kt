package cl.tiocomegfas.lib.network.compiler.internal

import cl.tiocomegfas.lib.network.annotation.HEADER
import cl.tiocomegfas.lib.network.annotation.Header
import cl.tiocomegfas.lib.network.annotation.Query
import cl.tiocomegfas.lib.network.annotation.Url
import com.google.devtools.ksp.symbol.KSValueParameter

internal fun KSValueParameter.isQueryAnnotation(): Boolean {
    return this.annotations.firstOrNull {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == Query::javaClass.name
    } != null
}

internal fun KSValueParameter.isUrlAnnotation(): Boolean {
    return this.annotations.firstOrNull {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == Url::javaClass.name
    } != null
}

internal fun KSValueParameter.isHeaderAnnotation(): Boolean {
    return this.annotations.firstOrNull {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == Header::javaClass.name
    } != null
}

internal fun KSValueParameter.getQueryAnnotation(): Query {
    return this.annotations.first {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == Query::javaClass.name
    } as Query
}

internal fun KSValueParameter.getUrlAnnotation(): Url {
    return this.annotations.first {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == Url::javaClass.name
    } as Url
}

internal fun KSValueParameter.getHeaderAnnotation(): Header {
    return this.annotations.first {
        it.annotationType.resolve().declaration.qualifiedName?.asString() == Header::javaClass.name
    } as Header
}