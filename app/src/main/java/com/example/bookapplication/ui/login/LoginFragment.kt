package com.example.bookapplication.ui.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentLoginBinding
import com.example.bookapplication.extension.preferences

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, LoginViewModelFactory(requireContext().preferences))
            .get(LoginViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.autoLogin()
        viewModel.haveAccess.observe(viewLifecycleOwner, { isAccess ->
            if (isAccess) {
                findNavController().navigate(R.id.action_loginFragment_to_bestSellersFragment)
            } else {
                Toast.makeText(context, getString(R.string.auth_alert), Toast.LENGTH_SHORT).show()
            }
        })

        binding.inputBtn.setOnClickListener {
            val login = binding.loginField.text.toString()
            val password = binding.passwordField.text.toString()
            val autologin = binding.isAutologin.isChecked
            viewModel.authorization(login, password, autologin)
        }
    }
}