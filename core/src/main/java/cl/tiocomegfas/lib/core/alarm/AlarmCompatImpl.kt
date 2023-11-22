package cl.tiocomegfas.lib.core.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.Calendar
import kotlin.reflect.KClass

internal class AlarmCompatImpl(
    private val context: Context
): AlarmCompat {
    private var manager: AlarmManager? = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    override fun configureAlarm(data: AlarmData, receiver: KClass<AlarmReceiver>) {
        val intent = Intent(context, receiver.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)

        // Configure time to wake up
        val timeToWakeUp = Calendar.getInstance()
        timeToWakeUp.set(Calendar.HOUR_OF_DAY, data.hourWakeUp)
        timeToWakeUp.set(Calendar.MINUTE, data.minutesWakeUp)
        timeToWakeUp.set(Calendar.SECOND, data.secondsWakeUp)

        // Configure time to nex day for wake up
        val newTimeToWakeUp = Calendar.getInstance()
        newTimeToWakeUp.time = timeToWakeUp.time
        newTimeToWakeUp.add(
            Calendar.DAY_OF_YEAR,
            if(data.repeatInHours < 24) 1 else data.repeatInHours / 24
        )

        manager?.setRepeating(
            AlarmManager.RTC_WAKEUP,
            newTimeToWakeUp.time.time,
            data.repeatInHours.toLong(),
            pendingIntent
        )
    }

    override fun cancelAlarm(receiver: KClass<AlarmReceiver>) {
        val intent = Intent(context, receiver.java)
        val sender = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        manager?.cancel(sender)
    }
}