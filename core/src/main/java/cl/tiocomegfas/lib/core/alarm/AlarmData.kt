package cl.tiocomegfas.lib.core.alarm

import androidx.annotation.IntRange

data class AlarmData(
    @IntRange(from = 0, to = 23) val hourWakeUp: Int,
    @IntRange(from = 0, to = 59) val minutesWakeUp: Int = 0,
    @IntRange(from = 0, to = 59) val secondsWakeUp: Int = 0,
    val repeatInHours: Int
)
