package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime

expect infix fun MultiplatformDateTime.isAfter(time: MultiplatformDateTime): Boolean

expect fun MultiplatformDateTime.isAfter(hours: Int, minutes: Int): Boolean

expect infix fun MultiplatformDateTime.isBefore(time: MultiplatformDateTime): Boolean

expect fun MultiplatformDateTime.isBefore(hours: Int, minutes: Int): Boolean

expect fun MultiplatformDateTime.isBetween(
    startDateTime: MultiplatformDateTime,
    endDateTime: MultiplatformDateTime
): Boolean

expect fun MultiplatformDateTime.timeUntilInHours(nextMultiplatformDateTime: MultiplatformDateTime): Double

expect fun MultiplatformDateTime.isOnSameDay(otherMultiplatformDateTime: MultiplatformDateTime): Boolean