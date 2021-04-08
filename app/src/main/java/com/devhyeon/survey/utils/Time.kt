package com.devhyeon.survey.utils

import java.text.SimpleDateFormat
import java.util.*

fun getNowDate() : String {
    val currentDateTime = Calendar.getInstance().time
    return SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.KOREA).format(currentDateTime).toString()
}