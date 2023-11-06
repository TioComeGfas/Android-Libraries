package cl.tiocomegfas.lib.network

data class ResponseBody(
    val bytes: ByteArray?,
    val code: ResponseCode
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ResponseBody

        if (bytes != null) {
            if (other.bytes == null) return false
            if (!bytes.contentEquals(other.bytes)) return false
        } else if (other.bytes != null) return false
        if (code != other.code) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bytes?.contentHashCode() ?: 0
        result = 31 * result + code.hashCode()
        return result
    }
}