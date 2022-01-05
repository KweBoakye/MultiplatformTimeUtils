package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime
import platform.Foundation.NSCalendar
import platform.Foundation.NSCalendarMatchStrictly
import platform.Foundation.NSCalendarUnitHour
import platform.Foundation.NSCalendarUnitMinute
import platform.Foundation.NSDate
import platform.Foundation.NSDateComponents
import platform.Foundation.NSOrderedAscending
import platform.Foundation.NSOrderedDescending
import platform.Foundation.compare
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import kotlin.math.floor

actual object MultiplatformDateTimeUtils {
    actual fun multiplatformDateTimeNow(): MultiplatformDateTime {
        return NSDate()
    }

    actual fun getDateTimeAtStartOfToday(): MultiplatformDateTime {
        return NSCalendar.currentCalendar().startOfDayForDate(NSDate())
    }

    actual fun getDateTimeAtEndOfToday(): MultiplatformDateTime {
        return NSDate().atEndOfDay()
    }

    actual fun getDateTimeAtTimeToday(hours: Int, minutes: Int): MultiplatformDateTime {
        val calendar = NSCalendar.currentCalendar()
        val dateNow = NSDate()
        return calendar.dateBySettingHour(
            hours.toLong(),
            minutes.toLong(),
            0,
            dateNow,
            NSCalendarMatchStrictly
        )!!
    }

    actual fun checkIsTimeNowBefore(hours: Int, minutes: Int): Boolean {
        return multiplatformDateTimeNow()
            .compare(getDateTimeAtTimeToday(hours, minutes)) == NSOrderedAscending
    }

    actual fun checkIsTimeNowAfter(hours: Int, minutes: Int): Boolean {
        return multiplatformDateTimeNow()
            .compare(getDateTimeAtTimeToday(hours, minutes)) == NSOrderedDescending
    }
}

actual fun getMultiplatformDateTimeNow(): MultiplatformDateTime {
    return NSDate()
}

actual fun MultiplatformDateTime.atStartOfDay(): MultiplatformDateTime {
    return NSCalendar.currentCalendar().startOfDayForDate(this)
}

actual fun MultiplatformDateTime.atEndOfDay(): MultiplatformDateTime {
    val dateComponents = NSDateComponents()
    dateComponents.nanosecond = -1
    return NSCalendar
        .currentCalendar()
        .dateByAddingComponents(
            dateComponents,
            atStartOfDay().addDays(1.toLong()),
            NSCalendarMatchStrictly
        )!!
}

actual fun MultiplatformDateTime.toMillis(): Long {
    return (floor(timeIntervalSince1970)
         * MultiplatformDateTimeConstants.SECONDS_TO_MILLISECONDS_SCALE_FACTOR).toLong()
}

actual fun Long.millisecondsToMultiplatformDateTime(): MultiplatformDateTime {
    return NSDate.dateWithTimeIntervalSince1970(
        secs = (this / MultiplatformDateTimeConstants.SECONDS_TO_MILLISECONDS_SCALE_FACTOR).toDouble()
    )
}
actual fun MultiplatformDateTime.getHourCommon(): Int {
    val calendar = NSCalendar.currentCalendar()
    return calendar.component(NSCalendarUnitHour, this).toInt()
}

actual fun MultiplatformDateTime.getMinuteCommon(): Int {
    val calendar = NSCalendar.currentCalendar()
    return calendar.component(NSCalendarUnitMinute, this).toInt()
}
