package com.example.zanatbizkod.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.example.zanatbizkod.R
import com.example.zanatbizkod.databinding.FragmentSignUpBinding
import com.example.zanatbizkod.viewmodel.SignUpFragmentViewModel
import com.google.android.material.textfield.TextInputEditText
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment() {

    private val signUpViewModel by viewModel<SignUpFragmentViewModel>()
    private var binding: FragmentSignUpBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSignUpBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            toolbarLayout.navigationButton.setOnClickListener { findNavController().popBackStack() }

            privatePersonListeners()
            legalEntityListeners()

            switchCustomerType.setOnCheckedChangeListener { _, isChecked ->
                isChecked.changeCustomerType()
            }

            cbTermsAndConditions.setOnCheckedChangeListener { _, _ ->
                enableSignUpButton(areAllFieldsValid())
            }

            tvTermsAndConditions.setOnClickListener { termsAndConditions() }
            tvLoginAdditionalText.setOnClickListener { findNavController().backToPreviousScreen() }
            buttonSignUp.setOnClickListener { signUp() }
        }
    }

    private fun FragmentSignUpBinding.privatePersonListeners() {
        inputNameField.afterTextChangedListener()
        inputSurnameField.afterTextChangedListener()
        inputPhoneNumberField.afterTextChangedListener()
        inputEmailField.afterTextChangedListener()
        inputPasswordField.afterTextChangedListener()
    }

    private fun FragmentSignUpBinding.legalEntityListeners() {
        inputCompanyNameField.afterTextChangedListener()
        inputPasswordLegalEntityField.afterTextChangedListener()
        inputIDNumberField.afterTextChangedListener()
        inputContactPhoneNumberField.afterTextChangedListener()
        inputContactEmailField.afterTextChangedListener()
    }

    private fun Boolean.changeCustomerType() {
        binding?.apply {
            enableSignUpButton(areAllFieldsValid())

            groupPrivatePerson.isGone = this@changeCustomerType
            groupLegalEntity.isGone = this@changeCustomerType.not()

            val params = cbTermsAndConditions.layoutParams as ConstraintLayout.LayoutParams

            params.topToBottom = when (this@changeCustomerType) {
                true -> inputContactEmail.id
                false -> inputPassword.id
            }
            cbTermsAndConditions.requestLayout()
        }
    }

    private fun TextInputEditText.afterTextChangedListener() {
        doAfterTextChanged {
            checkInput()
        }
    }

    private fun TextInputEditText.checkInput() {
        val inputType = hint.toString()
        val input = text.toString()

        error = when (inputType) {
            getString(R.string.phone_number) -> {
                if (input.isValidPhoneNumber().not()) getString(R.string.error_message, inputType)
                else null
            }
            getString(R.string.e_mail) -> {
                if (input.isValidEmail().not()) getString(R.string.error_message, inputType)
                else null
            }
            getString(R.string.password) -> {
                if (input.isValidPassword().not()) getString(R.string.error_message, inputType)
                else null
            }
            getString(R.string.tax_ID) -> {
                if (input.isValidTaxID().not()) getString(R.string.error_message, inputType)
                else null
            }
            getString(R.string.ID_number) -> {
                if (input.isValidIDNumber().not()) getString(R.string.error_message, inputType)
                else null
            }
            else -> {
                if (input.isValidName().not()) getString(R.string.error_message, inputType)
                else null
            }
        }
        enableSignUpButton(binding?.areAllFieldsValid() ?: false)
    }

    private fun enableSignUpButton(isEnabled: Boolean) {
        var color: Int
        binding?.apply {
            color = if (isEnabled) ContextCompat.getColor(requireContext(), R.color.beige)
            else ContextCompat.getColor(requireContext(), R.color.gray)

            buttonSignUp.setBackgroundColor(color)
            buttonSignUp.isEnabled = isEnabled
        }
    }

    private fun String.isValidPhoneNumber(): Boolean =
        isNotEmpty() && android.util.Patterns.PHONE.matcher(this).matches()

    private fun String.isValidEmail(): Boolean =
        isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

    private fun String.isValidPassword(): Boolean =
        isNotEmpty() && length >= 8 && contains(" ").not()

    private fun String.isValidName(): Boolean =
        isNotEmpty() && length >= 2

    private fun String.isValidTaxID(): Boolean =
        isNotEmpty() && length == 9

    private fun String.isValidIDNumber(): Boolean =
        isNotEmpty() && length == 8

    private fun FragmentSignUpBinding.areAllFieldsValid(): Boolean {
        return when (switchCustomerType.isChecked) {
            true -> isValidCompanyData()
            false -> isValidPrivatePersonData()
        }
    }

    private fun FragmentSignUpBinding.isValidPrivatePersonData(): Boolean {
        if (inputNameField.isValid() && inputSurnameField.isValid() &&
            inputPhoneNumberField.isValid() && inputEmailField.isValid() &&
            inputPasswordField.isValid() && cbTermsAndConditions.isChecked
        ) return true
        return false
    }

    private fun FragmentSignUpBinding.isValidCompanyData(): Boolean {
        if (inputCompanyNameField.isValid() && inputPasswordLegalEntityField.isValid() &&
            inputIDNumberField.isValid() && inputContactPhoneNumberField.isValid() &&
            inputContactEmailField.isValid() && cbTermsAndConditions.isChecked
        ) return true
        return false
    }

    private fun TextInputEditText.isValid() =
        text?.isNotEmpty() == true && error == null

    private fun termsAndConditions() {
        //R.id.termsAndConditionsFragment.navigate(requireView())
    }

    private fun FragmentSignUpBinding.signUp() {
        when (switchCustomerType.isChecked) {
            true -> signUpViewModel.sendSignUpInformationLegalEntity(
                inputCompanyNameField.text.toString(),
                inputPasswordLegalEntityField.text.toString(),
                inputIDNumberField.text.toString(),
                inputContactPhoneNumberField.text.toString(),
                inputContactEmailField.text.toString(),
            )
            false -> signUpViewModel.sendSignUpInformationPrivatePerson(
                inputEmailField.text.toString(),
                inputPasswordField.text.toString(),
                inputPhoneNumberField.text.toString(),
                inputNameField.text.toString(),
                inputSurnameField.text.toString(),
            )
        }
        signUpLiveDataHandler()
    }

    private fun signUpLiveDataHandler() {
        binding?.apply {
            signUpViewModel.signUpLiveData.observe(viewLifecycleOwner) { result ->
                if(result == true) {
                    R.id.homeFragment.navigate(requireView())
                } else {
                    getString(R.string.unsuccessful_signup).snackbar(requireView())
                }
            }
        }
    }
}