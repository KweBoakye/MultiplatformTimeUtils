package com.multiplatformtimeutils.utils

import kotlinx.datetime.DateTimeUnit
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
object MultiplatformDateTimeConstants {


     val SECONDS_TO_MICROSECONDS_SCALE_FACTOR = DateTimeUnit.SECOND.duration / DateTimeUnit.MICROSECOND.duration
     val SECONDS_TO_MILLISECONDS_SCALE_FACTOR = DateTimeUnit.SECOND.duration / DateTimeUnit.MILLISECOND.duration
    val HOURS_TO_SECONDS_RATIO = DateTimeUnit.HOUR. duration / DateTimeUnit.SECOND.duration
}