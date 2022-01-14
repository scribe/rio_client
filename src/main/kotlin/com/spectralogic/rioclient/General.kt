/**
 * ***************************************************************************
 *    Copyright 2014-2021 Spectra Logic Corporation. All Rights Reserved.
 * ***************************************************************************
 */
package com.spectralogic.rioclient

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode

data class PageInfo(
    val number: Long,
    val pageSize: Long,
    val totalPages: Long,
    val totalItems: Long = 0L
)

interface PageData<T> {
    val objects: List<T>
    val page: PageInfo
}

class RioHttpException(
    val httpMethod: HttpMethod,
    val urlStr: String,
    override val cause: Throwable,
    val statusCode: HttpStatusCode = HttpStatusCode.BadRequest
) : RuntimeException("${httpMethod.value} $urlStr (${statusCode.value}): ${cause.message}", cause) {
    fun payload(): String =
        "{${cause.message?.substringAfter("{")?.substringBeforeLast("}") ?: "Unknown"}}"
}
