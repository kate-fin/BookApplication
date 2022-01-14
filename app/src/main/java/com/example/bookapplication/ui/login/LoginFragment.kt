package com.example.bookapplication.ui.login


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentLoginBinding
import com.example.bookapplication.extensions.appComponent
import javax.inject.Inject

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel
    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        context?.appComponent?.inject(this)
        viewModel = ViewModelProvider(this, viewModelProvider)
            .get(LoginViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.loginPrBar.visibility = View.GONE
        viewModel.autoLogin()
        viewModel.uiStateAuthorization.observe(viewLifecycleOwner, { uiState ->
            if (uiState.isLoading) {
                binding.loginPrBar.visibility = View.VISIBLE
            } else {
                binding.loginPrBar.visibility = View.GONE
            }
            if (uiState.isLoggedIn != null) {
                if (uiState.isLoggedIn) {
                    findNavController().navigate(R.id.action_loginFragment_to_bestSellersFragment)
                } else {
                    Toast.makeText(context, getString(R.string.auth_alert), Toast.LENGTH_SHORT).show()
                    Log.i("LoginFragment", "login or password are incorrect")
                }
            }
        })

        binding.loginInputBtn.setOnClickListener {
            val login = binding.loginField.text.toString()
            val password = binding.passwordField.text.toString()
            val autologin = binding.isAutologin.isChecked
            viewModel.authorization(login, password, autologin)
        }
    }
}