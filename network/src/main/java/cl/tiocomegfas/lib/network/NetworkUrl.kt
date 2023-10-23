package cl.tiocomegfas.lib.network

abstract class NetworkUrl(
    open var uri: String
) {
    abstract val scheme: String
    private var listQuery: List<NetworkQuery> = emptyList()

    fun getUrl(base: String): String {
        return buildString {
            append(scheme)
            append(base)
            append(uri)
            append("?")
            listQuery.forEachIndexed { index, query ->
                append("${query.key}=${query.value}")
                if(index < listQuery.lastIndex) append("&")
            }
        }
    }

    fun addQuery(query: NetworkQuery) {
        if(!listQuery.contains(query)) listQuery = listQuery.plus(query)
    }

    internal class DefaultUrl: NetworkUrl("") {
        override val scheme: String
            get() = ""
    }

    internal class HttpUrl(
        override var uri: String
    ): NetworkUrl(uri) {
        override val scheme: String
            get() = "http://"
    }

    internal class HttpsUrl constructor(
        override var uri: String
    ): NetworkUrl(uri) {
        override val scheme: String
            get() = "https://"
    }

    object Factory {
        fun createHttps(uri: String): NetworkUrl = HttpsUrl(uri)
        fun createHttp(uri: String): NetworkUrl = HttpUrl(uri)
        internal fun createDefault(): NetworkUrl = DefaultUrl()
    }
}