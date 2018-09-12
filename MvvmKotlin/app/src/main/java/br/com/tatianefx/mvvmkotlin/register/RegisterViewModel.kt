package br.com.tatianefx.mvvmkotlin.register

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.annotation.StringRes
import br.com.tatianefx.mvvmkotlin.base.SingleLiveEvent
import br.com.tatianefx.mvvmkotlin.data.User
import br.com.tatianefx.mvvmkotlin.R

/**
 * Created by tatianefx on 11/09/2018.
 */

class RegisterViewModel(context: Application): AndroidViewModel(context) {

    val email = ObservableField<String>()
    val name = ObservableField<String>()
    val password = ObservableField<String>()
    internal val snackbarMessage = SingleLiveEvent<Int>()
    internal val taskUpdatedEvent = SingleLiveEvent<Void>()

    fun saveUser() {
        val user = User(
                email.get() ?: "",
                name.get() ?: "",
                password.get() ?: "")
        if (user.isEmptyToCreate) {
            showSnackbarMessage(R.string.empty_user_to_register_message)
            return
        }
        createUser(user)
    }

    private fun createUser(newUser: User) {
        //TODO call service to create user.
        taskUpdatedEvent.call()
    }

    private fun showSnackbarMessage(@StringRes message: Int) {
        snackbarMessage.value = message
    }
}