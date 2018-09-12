package br.com.tatianefx.mvvmkotlin.register

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tatianefx.mvvmkotlin.R
import br.com.tatianefx.mvvmkotlin.databinding.FragmentRegisterBinding
import br.com.tatianefx.mvvmkotlin.util.setupSnackbar


/**
 * Created by tatianefx on 11/09/2018.
 */

class RegisterFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActionBar()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_register, container, false)
        viewDataBinding = FragmentRegisterBinding.bind(root).apply {
            viewmodel = (activity as RegisterActivity).obtainViewModel()
        }
        retainInstance = false
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewmodel?.let {
            view?.setupSnackbar(this, it.snackbarMessage, Snackbar.LENGTH_LONG)
        }
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.register_user)
    }

    companion object {
        const val REGISTER_USER_ID = "REGISTER_USER_ID"

        fun newInstance() = RegisterFragment()
    }
}
