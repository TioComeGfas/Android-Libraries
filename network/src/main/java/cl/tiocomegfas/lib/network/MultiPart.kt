package cl.tiocomegfas.lib.network

import java.io.DataOutputStream
import java.io.File
import java.io.OutputStream

interface MultiPart {

    fun write(key: String, value: String)
}