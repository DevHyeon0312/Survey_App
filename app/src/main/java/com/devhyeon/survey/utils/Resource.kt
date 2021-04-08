package com.devhyeon.survey.utils

sealed class Status<T>(
    val data: T? = null,
    val errorCode: Int? = null
) {
    class Run<T>(data: T? = null) : Status<T>(data)
    class Success<T>(data: T) : Status<T>(data)
    class Failure<T>(errorCode: Int) : Status<T>(null, errorCode)
}