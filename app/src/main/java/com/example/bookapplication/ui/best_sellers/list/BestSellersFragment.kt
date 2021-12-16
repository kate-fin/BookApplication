package com.example.bookapplication.ui.best_sellers.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentBestSellersBinding
import com.example.bookapplication.extension.appComponent
import com.example.bookapplication.extension.preferences
import com.example.bookapplication.interfaces.RepoService
import com.example.bookapplication.ui.login.LoginViewModel
import com.example.bookapplication.ui.login.LoginViewModelFactory
import javax.inject.Inject

class BestSellersFragment : Fragment() {
    private var _binding: FragmentBestSellersBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BestSellersViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBestSellersBinding.inflate(inflater, container, false)
        context?.appComponent?.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[BestSellersViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBestSellers()
        viewModel.spinner.observe(viewLifecycleOwner, { isLoading ->
            if (isLoading) {
                binding.booksPB.visibility = View.VISIBLE
            } else {
                binding.booksPB.visibility = View.GONE
            }
        })

        viewModel.error.observe(viewLifecycleOwner, { isError ->
            if (isError) {
                binding.booksPB.visibility = View.GONE
                Toast.makeText(context, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.bestSellersLiveData.observe(viewLifecycleOwner, {bestSellers ->
//            binding.textView.text = bestSellers.numResults.toString()
            val adapter = BooksAdapter(bestSellers)
            binding.booksRV.adapter = adapter
        })
    }
}