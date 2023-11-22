package cl.tiocomegfas.lib.core.alarm

import kotlin.reflect.KClass

interface AlarmCompat {
    fun configureAlarm(data: AlarmData, receiver: KClass<AlarmReceiver>)
    fun cancelAlarm(receiver: KClass<AlarmReceiver>)
}