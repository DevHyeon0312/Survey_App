package com.devhyeon.survey.usecase.base

abstract class ApiUseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(params: Params? = null): Type

}
