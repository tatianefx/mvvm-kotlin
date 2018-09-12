package br.com.tatianefx.mvvmkotlin.data

import com.squareup.moshi.JsonClass

/**
 * Created by tatianefx on 10/09/2018.
 */

@JsonClass(generateAdapter = true)
data class ResponseSuccess(
        val type: String,
        val token: String
)