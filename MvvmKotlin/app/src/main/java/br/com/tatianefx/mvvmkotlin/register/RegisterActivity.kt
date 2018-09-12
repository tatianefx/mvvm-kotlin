package br.com.tatianefx.mvvmkotlin.register

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.tatianefx.mvvmkotlin.R
import br.com.tatianefx.mvvmkotlin.util.obtainViewModel
import br.com.tatianefx.mvvmkotlin.util.replaceFragmentInActivity
import br.com.tatianefx.mvvmkotlin.util.setupActionBar

/**
 * Created by tatianefx on 10/09/2018.
 */

class RegisterActivity : AppCompatActivity(), RegisterNavigator {

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onUserRegistered() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupActionBar(R.id.toolbar) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        replaceFragmentInActivity(obtainViewFragment(), R.id.contentFrame)

        subscribeToNavigationChanges()
    }

    private fun subscribeToNavigationChanges() {
        // The activity observes the navigation events in the ViewModel
        obtainViewModel().taskUpdatedEvent.observe(this, Observer {
            this@RegisterActivity.onUserRegistered()
        })
    }

    private fun obtainViewFragment() = supportFragmentManager.findFragmentById(R.id.contentFrame) ?:
    RegisterFragment.newInstance().apply {
        arguments = Bundle().apply {
            putString(RegisterFragment.REGISTER_USER_ID,
                    intent.getStringExtra(RegisterFragment.REGISTER_USER_ID))
        }
    }

    fun obtainViewModel(): RegisterViewModel = obtainViewModel(RegisterViewModel::class.java)
}
