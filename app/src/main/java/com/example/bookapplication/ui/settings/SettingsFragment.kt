package com.example.bookapplication.ui.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentSettingsBinding
import com.example.bookapplication.extension.*
import com.example.bookapplication.ui.ViewModelFactory
import javax.inject.Inject

class SettingsFragment: Fragment() {
    private var _binding:FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SettingsViewModel
    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        context?.appComponent?.inject(this)
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelProvider).get(SettingsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settingsPrBar.visibility = View.GONE
//        binding.settingsLoginEditText.setText(preferences.login)
//        binding.settingsPasswordEditText.setText(preferences.password)

        viewModel.uiStateLogin.observe(viewLifecycleOwner, { uiState ->
            if (uiState.isLoading) {
                binding.settingsPrBar.visibility = View.VISIBLE
            } else {
                binding.settingsPrBar.visibility = View.GONE
            }
            if (uiState.errorMessageCode != null) {
                view.context.showAlert(
                    title = getString(R.string.login_error_title),
                    message = getString(uiState.errorMessageCode)
                )
            }
        })

        viewModel.uiStatePassword.observe(viewLifecycleOwner, { uiState ->
            if (uiState.isLoading) {
                binding.settingsPrBar.visibility = View.VISIBLE
            } else {
                binding.settingsPrBar.visibility = View.GONE
            }
            if (uiState.errorMessageCode != null) {
                view.context.showAlert(
                    title = getString(R.string.password_error_title),
                    message = getString(uiState.errorMessageCode)
                )
            }
        })

        binding.settingsLoginEditText.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val login = binding.settingsLoginEditText.text.toString()
                viewModel.saveLogin(login)
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        binding.settingsPasswordEditText.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                viewModel.savePassword(binding.settingsPasswordEditText.text.toString())
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        binding.settingsSaveChanges.setOnClickListener {
            viewModel.saveLogin(binding.settingsLoginEditText.text.toString())
            viewModel.savePassword(binding.settingsPasswordEditText.text.toString())
        }

        binding.settingsToolbar.backArrow.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.settingsExit.setOnClickListener {
            viewModel.saveAutologin(false)
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToLoginFragment())
        }
    }
}