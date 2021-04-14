package com.devhyeon.survey.network.usecase.base

abstract class ApiUseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(params: Params? = null): Type

}
