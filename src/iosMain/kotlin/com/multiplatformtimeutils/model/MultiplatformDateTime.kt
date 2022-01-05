package com.multiplatformtimeutils.model

import platform.Foundation.NSDate
import platform.Foundation.compare

actual typealias MultiplatformDateTime = NSDate

actual object MultiplatformDateTimeComparator : Comparator<MultiplatformDateTime> {
    override fun compare(a: MultiplatformDateTime, b: MultiplatformDateTime): Int {
        return a.compare(b).toInt()
    }
}