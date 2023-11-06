package cl.tiocomegfas.lib.persistence

import android.content.Context
import kotlinx.coroutines.runBlocking
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SharedPreferencesDelegate<T>(
    private val context: Context,
    private val fileName: String,
    private val name: String,
    private val defaultValue: T,
): ReadWriteProperty<Any?, T> {

    private val persistence: Persistence by lazy {
        PersistenceFactory.createSharedPreferences(context, fileName)
    }
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return runBlocking {
            persistence.read(name, defaultValue)
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        return runBlocking {
            persistence.write(name, value)
        }
    }
}