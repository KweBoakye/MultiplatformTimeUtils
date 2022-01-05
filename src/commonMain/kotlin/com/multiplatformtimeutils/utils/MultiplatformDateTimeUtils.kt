package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime

expect object MultiplatformDateTimeUtils {

    fun multiplatformDateTimeNow(): MultiplatformDateTime

    fun getDateTimeAtStartOfToday(): MultiplatformDateTime

    fun getDateTimeAtEndOfToday(): MultiplatformDateTime

    fun getDateTimeAtTimeToday(hours: Int, minutes: Int): MultiplatformDateTime

    fun checkIsTimeNowBefore(hours: Int, minutes: Int): Boolean

    fun checkIsTimeNowAfter(hours: Int, minutes: Int): Boolean
}
expect fun getMultiplatformDateTimeNow(): MultiplatformDateTime

expect fun MultiplatformDateTime.atStartOfDay(): MultiplatformDateTime

expect fun MultiplatformDateTime.atEndOfDay(): MultiplatformDateTime

expect fun MultiplatformDateTime.toMillis(): Long

expect fun Long.millisecondsToMultiplatformDateTime(): MultiplatformDateTime

expect fun MultiplatformDateTime.getHourCommon(): Int

expect fun MultiplatformDateTime.getMinuteCommon(): Int
