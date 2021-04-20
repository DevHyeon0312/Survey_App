package com.devhyeon.survey.network.usecase.base

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.TakeResult

abstract class ApiUseCase<Type, in Params>() where Type : Any {
    abstract suspend fun run(params: Params? = null): Type
}


abstract class ApiUseCase2<Type, in Params>() where Type : Any {
    abstract suspend fun run(p1: Any?, p2: Any?): TakeResult
}