package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime
import kotlinx.datetime.internal.JSJoda.Instant
import kotlinx.datetime.internal.JSJoda.LocalDate
import kotlinx.datetime.internal.JSJoda.LocalTime
import kotlinx.datetime.internal.JSJoda.ZoneId
import kotlinx.datetime.internal.JSJoda.ZonedDateTime

actual object MultiplatformDateTimeUtils {
    actual fun multiplatformDateTimeNow(): MultiplatformDateTime {
        return getMultiplatformDateTimeNow()
    }

    actual fun getDateTimeAtStartOfToday(): MultiplatformDateTime {
        return multiplatformDateTimeNow().atStartOfDay()

    }

    actual fun getDateTimeAtEndOfToday(): MultiplatformDateTime {
        return ZonedDateTime.of(
            date = LocalDate.Companion.now(ZoneId.systemDefault()),
            time = LocalTime.MAX,
            ZoneId.systemDefault()
        )
    }

    actual fun getDateTimeAtTimeToday(
        hours: Int,
        minutes: Int
    ): MultiplatformDateTime {
        return LocalDate.now(ZoneId.systemDefault())
            .atTime(
                hour = hours,
                minute = minutes
            )
            .atZone(ZoneId.systemDefault())
    }

    actual fun checkIsTimeNowBefore(hours: Int, minutes: Int): Boolean {
        return multiplatformDateTimeNow().isBefore(getDateTimeAtTimeToday(hours, minutes))
    }

    actual fun checkIsTimeNowAfter(hours: Int, minutes: Int): Boolean {
        return multiplatformDateTimeNow().isAfter(getDateTimeAtTimeToday(hours, minutes))
    }

}

actual fun getMultiplatformDateTimeNow(): MultiplatformDateTime {
    return ZonedDateTime.Companion.now(ZoneId.systemDefault())
}

actual fun MultiplatformDateTime.atStartOfDay(): MultiplatformDateTime {
    return toLocalDate().atStartOfDay(ZoneId.systemDefault())
}

actual fun MultiplatformDateTime.atEndOfDay(): MultiplatformDateTime {
    return ZonedDateTime.of(
        date = this.toLocalDate(),
        time = LocalTime.MAX,
        ZoneId.systemDefault()
    )
}

actual fun MultiplatformDateTime.toMillis(): Long {
    return this.toInstant().toEpochMilli().toLong()
}

actual fun Long.millisecondsToMultiplatformDateTime(): MultiplatformDateTime {
    return Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault())
}

actual fun MultiplatformDateTime.getHourCommon(): Int {
    return hour().toInt()
}

actual fun MultiplatformDateTime.getMinuteCommon(): Int {
    return minute().toInt()
}