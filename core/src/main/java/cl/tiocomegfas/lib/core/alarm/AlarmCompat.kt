package cl.tiocomegfas.lib.core.alarm

import kotlin.reflect.KClass

interface AlarmCompat {
    fun <T: AlarmReceiver> configureAlarm(data: AlarmData, receiver: KClass<T>)
    fun <T: AlarmReceiver> cancelAlarm(receiver: KClass<T>)
}