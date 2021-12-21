package com.example.bookapplication.ui.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bookapplication.databinding.FragmentSettingBinding
import com.example.bookapplication.extension.appComponent
import com.example.bookapplication.extension.autologin
import com.example.bookapplication.extension.login
import com.example.bookapplication.extension.password
import javax.inject.Inject

class SettingsFragment: Fragment() {
    private var _binding:FragmentSettingBinding? = null
    private val binding = _binding!!

    @Inject
    lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        context?.appComponent?.inject(this)
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.text = preferences.login
        binding.password.text = preferences.password
        binding.isAutologin.isChecked = preferences.autologin

        binding.toolbar.backArrow.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}