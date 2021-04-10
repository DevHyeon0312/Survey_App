package com.devhyeon.survey.usecase.base

import com.devhyeon.survey.network.model.ApiError

interface ApiResponse<T> {
    fun onSuccess(result: T)
    fun onError(apiError: ApiError?)
}
