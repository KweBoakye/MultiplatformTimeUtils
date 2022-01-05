package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime

actual fun MultiplatformDateTime.addMinutes(minutes: Long): MultiplatformDateTime {
    return plusMinutes(minutes)
}

actual fun MultiplatformDateTime.addHours(hours: Long): MultiplatformDateTime {
    return plusHours(hours)
}

actual fun MultiplatformDateTime.addDays(days: Long): MultiplatformDateTime {
    return plusDays(days)
}

actual fun MultiplatformDateTime.subtractDays(days: Long): MultiplatformDateTime {
    return minusDays(days)
}

actual fun MultiplatformDateTime.subtractMinutes(minutes: Long): MultiplatformDateTime {
    return minusMinutes(minutes)
}
actual fun MultiplatformDateTime.subtractHours(hours: Long): MultiplatformDateTime {
    return minusHours(hours)
}