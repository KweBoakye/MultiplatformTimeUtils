package com.multiplatformtimeutils.model

import java.time.ZonedDateTime

actual typealias MultiplatformDateTime = ZonedDateTime

actual object MultiplatformDateTimeComparator : Comparator<MultiplatformDateTime> {

    override fun compare(o1: MultiplatformDateTime?, o2: MultiplatformDateTime?): Int {
        return if ((o1 == null) || o2 == null) {
            0
        } else {
            o1.compareTo(o2)
        }
    }
}