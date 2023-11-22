package cl.tiocomegfas.lib.network

abstract class MediaType internal constructor() {
    internal abstract val type: String
    internal abstract val subtype: String
    fun buildMediaType(): String = "$type/$subtype"
}