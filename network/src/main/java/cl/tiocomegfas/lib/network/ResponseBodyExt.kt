package cl.tiocomegfas.lib.network

fun ResponseBody.fromBytesToJson(): String? {
    return this.bytes?.contentToString()
}

fun ResponseBody.fromSchemeToJson(): String? {
    return ""
}
