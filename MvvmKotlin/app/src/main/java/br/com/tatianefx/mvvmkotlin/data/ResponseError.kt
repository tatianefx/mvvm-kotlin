package br.com.tatianefx.mvvmkotlin.data

import com.squareup.moshi.JsonClass
import java.util.ArrayList

/**
 * Created by tatianefx on 10/09/2018.
 */

@JsonClass(generateAdapter = true)
data class ResponseError(
        val type: String,
        val message: String,
        val errors: ArrayList<String>?
)