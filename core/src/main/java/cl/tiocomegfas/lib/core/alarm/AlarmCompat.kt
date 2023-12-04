package cl.tiocomegfas.lib.core.alarm

interface AlarmCompat {
    fun configureAlarm(data: AlarmData, receiver: Class<out AlarmReceiver>)
    fun cancelAlarm(receiver: Class<out AlarmReceiver>)
}