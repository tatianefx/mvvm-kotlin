package br.com.tatianefx.mvvmkotlin.data

import com.squareup.moshi.JsonClass

/**
 * Created by tatianefx on 10/09/2018.
 */

@JsonClass(generateAdapter = true)
data class User (
        val email: String,
        val name: String,
        var password: String
) {
    val isEmptyToCreate
        get() = email.isEmpty() && name.isEmpty() && password.isEmpty()
}