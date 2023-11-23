package cl.tiocomegfas.lib.core.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.Calendar
import java.util.Locale
import kotlin.reflect.KClass

internal class AlarmCompatImpl(
    private val context: Context
): AlarmCompat {
    private var manager: AlarmManager? = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    override fun <T : AlarmReceiver> configureAlarm(data: AlarmData, receiver: KClass<T>) {
        val intent = Intent(context, receiver.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)

        // Configure time to wake up
        val timeToWakeUp = Calendar.getInstance()
        timeToWakeUp.set(Calendar.HOUR_OF_DAY, data.hourWakeUp)
        timeToWakeUp.set(Calendar.MINUTE, data.minutesWakeUp)
        timeToWakeUp.set(Calendar.SECOND, data.secondsWakeUp)

        manager?.setRepeating(
            AlarmManager.RTC_WAKEUP,
            timeToWakeUp.timeInMillis,
            (1000 * 60 * 60 * data.repeatInHours).toLong(),
            pendingIntent
        )
    }

    override fun <T : AlarmReceiver> cancelAlarm(receiver: KClass<T>) {
        val intent = Intent(context, receiver.java)
        val sender = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        manager?.cancel(sender)
    }
}