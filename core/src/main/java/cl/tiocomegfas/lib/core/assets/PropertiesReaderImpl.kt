package cl.tiocomegfas.lib.core.assets

import android.content.Context
import java.util.PropertyResourceBundle
import java.util.ResourceBundle

internal class PropertiesReaderImpl(
    private val context: Context
): PropertiesReader {
    private var bundle: ResourceBundle? = null

    override fun loadFile(name: String) {
        val resource = context.resources
        val assets = resource.assets
        bundle = PropertyResourceBundle(assets.open(name))
    }

    override fun readString(key: String, defaultValue: String): String {
        return try {
            bundle?.getString(key) ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    override fun readInt(key: String, defaultValue: Int): Int {
        return try {
            bundle?.getString(key)?.toInt() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    override fun readLong(key: String, defaultValue: Long): Long {
        return try {
            bundle?.getString(key)?.toLong() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    override fun readFloat(key: String, defaultValue: Float): Float {
        return try {
            bundle?.getString(key)?.toFloat() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    override fun readDouble(key: String, defaultValue: Double): Double {
        return try {
            bundle?.getString(key)?.toDouble() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    override fun readBoolean(key: String, defaultValue: Boolean): Boolean {
        return try {
            bundle?.getString(key)?.toBoolean() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }
}