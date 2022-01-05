package com.multiplatformtimeutils.model

import kotlinx.datetime.internal.JSJoda.ZonedDateTime

actual typealias MultiplatformDateTime = ZonedDateTime

actual object MultiplatformDateTimeComparator : Comparator<MultiplatformDateTime> {
    override fun compare(a: MultiplatformDateTime, b: MultiplatformDateTime): Int {
        return a.compareTo(b).toInt()

    }
}