package cl.tiocomegfas.lib.flagr.internal

import androidx.annotation.XmlRes
import cl.tiocomegfas.lib.flagr.Flagr
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

internal class FlagrImpl(
    @XmlRes val default: Int
): Flagr {
    private val remoteConfig: FirebaseRemoteConfig by lazy { Firebase.remoteConfig }

    override fun initialize(
        onSuccess: () -> Unit
    ) {
        remoteConfig.setConfigSettingsAsync(
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = 3600
            }
        )
        remoteConfig.setDefaultsAsync(default)
        remoteConfig.fetchAndActivate()
            .addOnSuccessListener { onSuccess.invoke() }
            .addOnFailureListener { onSuccess.invoke() }
    }

    override fun getBoolean(key: String): Boolean {
        return remoteConfig.getBoolean(key)
    }

    override fun getDouble(key: String): Double {
        return remoteConfig.getDouble(key)
    }

    override fun getLong(key: String): Long {
        return remoteConfig.getLong(key)
    }

    override fun getString(key: String): String {
        return remoteConfig.getString(key)
    }

    override fun getAll(): List<Pair<String, String>> {
        val list = mutableListOf<Pair<String, String>>()
        val items = remoteConfig.all.entries.toList()
        repeat(items.size) { index ->
            list.add(items[index].key to items[index].value.asString())
        }
        return list
    }

}