package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime


actual object MultiplatformDateTimeUtils {
    actual fun multiplatformDateTimeNow(): MultiplatformDateTime {
        return ZonedDateTime.now()
    }

    actual fun getDateTimeAtStartOfToday(): MultiplatformDateTime {
        return LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault())
    }

    actual fun getDateTimeAtEndOfToday(): MultiplatformDateTime {
        return LocalDate.now().atTime(LocalTime.MAX).atZone(ZoneId.systemDefault())
    }

    actual fun getDateTimeAtTimeToday(hours: Int, minutes: Int): MultiplatformDateTime {
        return LocalDate.now().atTime(hours, minutes).atZone(ZoneId.systemDefault())
    }

    actual fun checkIsTimeNowBefore(hours: Int, minutes: Int): Boolean {
        return multiplatformDateTimeNow().isBefore(getDateTimeAtTimeToday(hours, minutes))
    }

    actual fun checkIsTimeNowAfter(hours: Int, minutes: Int): Boolean {
        return multiplatformDateTimeNow().isAfter(getDateTimeAtTimeToday(hours, minutes))
    }
}

actual fun getMultiplatformDateTimeNow(): MultiplatformDateTime {
    return ZonedDateTime.now()
}

actual fun ZonedDateTime.toMillis(): Long {
    return toInstant().toEpochMilli()
}

actual fun Long.millisecondsToMultiplatformDateTime(): MultiplatformDateTime {
    return Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault())
}

fun LocalDateTime.toMillis(): Long {
    return atZone(ZoneId.systemDefault()).toMillis()
}

actual fun MultiplatformDateTime.atStartOfDay(): MultiplatformDateTime {
    return toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault())
}

actual fun MultiplatformDateTime.atEndOfDay(): MultiplatformDateTime {
    return toLocalDate().atTime(LocalTime.MAX).atZone(ZoneId.systemDefault())
}

actual fun MultiplatformDateTime.getHourCommon(): Int = hour
actual fun MultiplatformDateTime.getMinuteCommon(): Int = minute