package com.example.weatherapp.data.base_data

import com.example.weatherapp.data.base_data.model.AnotherError
import com.example.weatherapp.data.base_data.model.ResultStatus
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseDataSource {
    suspend fun <T> invokeResponseRequest(request: suspend () -> Response<T>): ResultStatus<T> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                ResultStatus.succes(
                    data = response.body()
                )
            } else {
                ResultStatus.error(
                    errorThrowable = AnotherError(
                        errorMassage = response.message(),
                        code = response.code()
                    ),
                    data = null
                )
            }
        } catch (httpExceptions: HttpException) {
            ResultStatus.error(errorThrowable = httpExceptions, data = null)
        } catch (e: Throwable) {
            ResultStatus.error(errorThrowable = e, data = null)
        }
    }
}