package com.multiplatformtimeutils.utils

import com.multiplatformtimeutils.model.MultiplatformDateTime

expect fun MultiplatformDateTime.addMinutes(minutes: Long): MultiplatformDateTime

expect fun MultiplatformDateTime.addHours(hours: Long): MultiplatformDateTime

expect fun MultiplatformDateTime.addDays(days: Long): MultiplatformDateTime

expect fun MultiplatformDateTime.subtractMinutes(minutes: Long): MultiplatformDateTime

expect fun MultiplatformDateTime.subtractHours(hours: Long): MultiplatformDateTime

expect fun MultiplatformDateTime.subtractDays(days: Long): MultiplatformDateTime