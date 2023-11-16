package cl.tiocomegfas.lib.network

import java.io.DataOutputStream
import java.io.File
import java.io.OutputStream

interface MultiPart {
    //private val twoHyphens = "--"
    //internal val boundary =  "*****"+ System.currentTimeMillis() +"*****"
    //private val lineEnd = "\r\n"
    fun write(key: String, value: String)
}