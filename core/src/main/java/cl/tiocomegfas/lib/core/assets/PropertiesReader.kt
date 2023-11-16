package cl.tiocomegfas.lib.core.assets

import android.content.Context
import java.util.PropertyResourceBundle
import java.util.ResourceBundle

abstract class PropertiesReader {
    private var bundle: ResourceBundle? = null
    abstract val file: String

    fun initialize(context: Context) {
        val resource = context.resources
        val assets = resource.assets
        bundle = PropertyResourceBundle(assets.open(file))
    }

    protected fun getString(key: String, defaultValue: String): String {
        return try {
            bundle?.getString(key) ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    protected fun getIntValue(key: String, defaultValue: Int): Int {
        return try {
            bundle?.getString(key)?.toInt() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    protected fun getLongValue(key: String, defaultValue: Long): Long {
        return try {
            bundle?.getString(key)?.toLong() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    protected fun getFloatValue(key: String, defaultValue: Float): Float {
        return try {
            bundle?.getString(key)?.toFloat() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    protected fun getDoubleValue(key: String, defaultValue: Double): Double {
        return try {
            bundle?.getString(key)?.toDouble() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }

    protected fun getBooleanValue(key: String, defaultValue: Boolean): Boolean {
        return try {
            bundle?.getString(key)?.toBoolean() ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }
}