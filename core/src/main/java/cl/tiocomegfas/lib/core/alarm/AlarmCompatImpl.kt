package cl.tiocomegfas.lib.core.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.getSystemService
import java.util.Calendar
import java.util.Locale
import kotlin.reflect.KClass

internal class AlarmCompatImpl(
    private val context: Context
): AlarmCompat {
    private var manager: AlarmManager = context.getSystemService<AlarmManager>()!!
    override fun configureAlarm(data: AlarmData, receiver: Class<out AlarmReceiver>) {
        val intent = Intent(context, receiver)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // Configure time to wake up
        val timeToWakeUp = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, data.hourWakeUp)
            set(Calendar.MINUTE, data.minutesWakeUp)
            set(Calendar.SECOND, data.secondsWakeUp)
        }

        manager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            timeToWakeUp.timeInMillis,
            (1000 * 60 * 60 * data.repeatInHours).toLong(),
            pendingIntent
        )
        Log.i("AlarmCompat", "Alarm configured in time :${timeToWakeUp.timeInMillis} with repeating: ${data.hourWakeUp} hours")
    }

    override fun cancelAlarm(receiver: Class<out AlarmReceiver>) {
        val intent = Intent(context, receiver)
        val sender = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        manager.cancel(sender)
        Log.i("AlarmCompat", "Alarm canceled")
    }
}