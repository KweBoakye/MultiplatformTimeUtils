package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit


actual infix fun MultiplatformDateTime.isAfter(time: MultiplatformDateTime): Boolean {
    return isAfter(time)
}

actual fun MultiplatformDateTime.isAfter(hours: Int, minutes: Int): Boolean {
    return isAfter(LocalDate.now().atTime(hours, minutes).atZone(ZoneId.systemDefault()))
}

actual infix fun MultiplatformDateTime.isBefore(time: MultiplatformDateTime): Boolean {
    return isBefore(time)
}

actual fun MultiplatformDateTime.isBefore(hours: Int, minutes: Int): Boolean {
    return isBefore(LocalDate.now().atTime(hours, minutes).atZone(ZoneId.systemDefault()))
}
actual fun MultiplatformDateTime.isBetween(startDateTime: MultiplatformDateTime, endDateTime: MultiplatformDateTime):
        Boolean {
    return (isAfter(startDateTime) and isBefore(endDateTime))
}

actual fun MultiplatformDateTime.timeUntilInHours(nextMultiplatformDateTime: MultiplatformDateTime): Double {
    return until(nextMultiplatformDateTime, ChronoUnit.MINUTES)
        .toDouble() / ChronoUnit.HOURS.duration.toMinutes()
}

actual fun MultiplatformDateTime.isOnSameDay(otherMultiplatformDateTime: MultiplatformDateTime): Boolean {
    return toLocalDate().isEqual(otherMultiplatformDateTime.toLocalDate())
}
