package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime
import com.multiplatformtimeutils.utils.MultiplatformDateTimeUtils.getDateTimeAtTimeToday
import kotlinx.datetime.internal.JSJoda.ChronoUnit

actual infix fun MultiplatformDateTime.isAfter(time: MultiplatformDateTime): Boolean {
    return isAfter(other = time)
}

actual fun MultiplatformDateTime.isAfter(hours: Int, minutes: Int): Boolean {
    return isAfter(other = getDateTimeAtTimeToday(hours, minutes))
}

actual infix fun MultiplatformDateTime.isBefore(time: MultiplatformDateTime): Boolean {
    return isBefore(other = time)
}

actual fun MultiplatformDateTime.isBefore(hours: Int, minutes: Int): Boolean {
    return isBefore(getDateTimeAtTimeToday(hours, minutes))
}

actual fun MultiplatformDateTime.isBetween(
    startDateTime: MultiplatformDateTime,
    endDateTime: MultiplatformDateTime
): Boolean {
    return (isAfter(startDateTime) and isBefore(endDateTime))
}

actual fun MultiplatformDateTime.timeUntilInHours(nextMultiplatformDateTime: MultiplatformDateTime): Double {
    return until(nextMultiplatformDateTime, ChronoUnit.MINUTES)
        .toDouble() / ChronoUnit.HOURS.duration().toMinutes().toDouble()
}

actual fun MultiplatformDateTime.isOnSameDay(otherMultiplatformDateTime: MultiplatformDateTime): Boolean {
    return this.isEqual(otherMultiplatformDateTime)
}
