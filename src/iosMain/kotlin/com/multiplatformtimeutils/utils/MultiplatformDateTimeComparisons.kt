package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime
import kotlinx.datetime.DateTimeUnit
import platform.Foundation.NSCalendar
import platform.Foundation.NSCalendarMatchStrictly
import platform.Foundation.NSDate
import platform.Foundation.NSOrderedAscending
import platform.Foundation.NSOrderedDescending
import platform.Foundation.compare
import platform.Foundation.timeIntervalSinceDate


actual infix fun MultiplatformDateTime.isAfter(time: MultiplatformDateTime): Boolean {
    return this.compare(
        time
    ) == NSOrderedDescending
}

actual fun MultiplatformDateTime.isAfter(hours: Int, minutes: Int): Boolean {
    val calendar = NSCalendar.currentCalendar()
    val dateNow = NSDate()
    val dateTimeToCompare = calendar
        .dateBySettingHour(
            hours.toLong(),
            minutes.toLong(),
            0,
            dateNow,
            NSCalendarMatchStrictly
        )!!
    return isAfter(dateTimeToCompare)
}

actual infix fun MultiplatformDateTime.isBefore(time: MultiplatformDateTime): Boolean {
    return compare(time) == NSOrderedAscending
}

actual fun MultiplatformDateTime.isBefore(hours: Int, minutes: Int): Boolean {
    val calendar = NSCalendar.currentCalendar()
    val dateNow = NSDate()
    val dateTimeToCompare = calendar
        .dateBySettingHour(
            hours.toLong(),
            minutes.toLong(),
            0,
            dateNow,
            NSCalendarMatchStrictly
        )!!
    return isBefore(dateTimeToCompare)
}

actual fun MultiplatformDateTime.isBetween(
    startDateTime: MultiplatformDateTime,
    endDateTime: MultiplatformDateTime
): Boolean {
    return (isAfter(startDateTime) and isBefore(endDateTime))
}

actual fun MultiplatformDateTime.timeUntilInHours(nextMultiplatformDateTime: MultiplatformDateTime): Double {
    return nextMultiplatformDateTime
        .timeIntervalSinceDate(this) / MultiplatformDateTimeConstants.HOURS_TO_SECONDS_RATIO
}

actual fun MultiplatformDateTime.isOnSameDay(otherMultiplatformDateTime: MultiplatformDateTime): Boolean {
    val calendar = NSCalendar.currentCalendar()
    return calendar.isDate(this, otherMultiplatformDateTime)
}
