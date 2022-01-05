package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime
import platform.Foundation.NSCalendar
import platform.Foundation.NSCalendarMatchStrictly
import platform.Foundation.NSDateComponents

actual fun MultiplatformDateTime.addDays(days: Long): MultiplatformDateTime {
    val dateComponents = NSDateComponents()
    dateComponents.setDay(days)
    return NSCalendar.currentCalendar().dateByAddingComponents(
        dateComponents,
        this,
        NSCalendarMatchStrictly
    )!!
}

actual fun MultiplatformDateTime.addHours(hours: Long): MultiplatformDateTime {
    val dateComponents = NSDateComponents()
    dateComponents.setHour(hours)
    return NSCalendar.currentCalendar().dateByAddingComponents(
        dateComponents,
        this,
        NSCalendarMatchStrictly
    )!!
}

actual fun MultiplatformDateTime.addMinutes(minutes: Long): MultiplatformDateTime {
    val dateComponents = NSDateComponents()
    dateComponents.setMinute(minutes)
    return NSCalendar.currentCalendar().dateByAddingComponents(
        dateComponents,
        this,
        NSCalendarMatchStrictly
    )!!
}

actual fun MultiplatformDateTime.subtractDays(days: Long): MultiplatformDateTime {
    val dateComponents = NSDateComponents()
    dateComponents.setDay(-days)
    return NSCalendar.currentCalendar().dateByAddingComponents(
        dateComponents,
        this,
        NSCalendarMatchStrictly
    )!!
}

actual fun MultiplatformDateTime.subtractMinutes(minutes: Long): MultiplatformDateTime {
    val dateComponents = NSDateComponents()
    dateComponents.setMinute(-minutes)
    return NSCalendar.currentCalendar().dateByAddingComponents(
        dateComponents,
        this,
        NSCalendarMatchStrictly
    )!!
}

actual fun MultiplatformDateTime.subtractHours(hours: Long): MultiplatformDateTime {
    val dateComponents = NSDateComponents()
    dateComponents.setHour(-hours)
    return NSCalendar.currentCalendar().dateByAddingComponents(
        dateComponents,
        this,
        NSCalendarMatchStrictly
    )!!
}
