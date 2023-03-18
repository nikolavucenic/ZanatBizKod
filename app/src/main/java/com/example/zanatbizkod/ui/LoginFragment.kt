package com.example.zanatbizkod.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zanatbizkod.R
import com.example.zanatbizkod.databinding.FragmentLoginBinding
import com.example.zanatbizkod.model.User
import com.example.zanatbizkod.viewmodel.LoginFragmentViewModel
import com.google.firebase.database.FirebaseDatabase
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null
    private val loginViewModel by viewModel<LoginFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            buttonLogin.setOnClickListener {
                it.hideKeyboard()
                //login()
                val database = FirebaseDatabase.getInstance()
                val usersRef = database.getReference("users")
                val user = User("jsaoffa", 412)
                usersRef.setValue(user)
            }
            buttonSignUp.setOnClickListener { signUp() }
            tvResetPassword.setOnClickListener { resetPassword() }
        }
    }

    private fun login() {
        binding?.apply {
            if (inputEmailField.text.isNullOrEmpty().not() &&
                inputPasswordField.text.isNullOrEmpty().not()) {

                loginViewModel.sendLoginInformation(
                    inputEmailField.text.toString(),
                    inputPasswordField.text.toString(),
                )

                loginLiveDataHandler()

            } else getString(R.string.empty_field_error).snackbar(requireView())
        }
    }

    private fun signUp() {
        R.id.signUpFragment.navigate(requireView())
    }

    private fun resetPassword() {
        //R.id.resetPasswordFragment.navigate(requireView())
    }

    private fun loginLiveDataHandler() {
        binding?.apply {
            loginViewModel.loginLiveData.observe(viewLifecycleOwner) { result ->
                result?.takeIf { it.accessToken.isNotEmpty() }?.apply {
                    //R.id.homeFragment.navigate(requireView())
                } ?: run {
                    getString(R.string.unsuccessful_login).snackbar(requireView())
                }
            }
        }
    }
}