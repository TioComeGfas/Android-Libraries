package cl.tiocomegfas.app.android_libraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.tiocomegfas.lib.network.NetworkFactory
import cl.tiocomegfas.lib.network.NetworkHeader
import cl.tiocomegfas.lib.network.NetworkQuery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = NetworkFactory.createApiRestClient(
            baseUrl = "",
            port = 399,
            timeout = 5000
        )
        client
            .header(NetworkHeader("", ""))
            .query(NetworkQuery("", ""))
            .jsonStrategy()
            .get()
            .execute()

    }
}