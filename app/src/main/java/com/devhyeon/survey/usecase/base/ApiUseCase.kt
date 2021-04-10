package com.devhyeon.survey.usecase.base

import com.devhyeon.survey.network.exceptions.traceErrorException
import kotlinx.coroutines.*
import java.util.concurrent.CancellationException

abstract class ApiUseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(params: Params? = null): Type

    fun invoke(scope: CoroutineScope, params: Params?, onResult: ApiResponse<Type>?) {
        scope.launch {
            try {
                val result = run(params)
                onResult?.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult?.onError(traceErrorException(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(traceErrorException(e))
            }
        }
    }
}
