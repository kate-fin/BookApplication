package com.example.bookapplication.best_sellers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bookapplication.BooksAdapter
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentFirstBinding

class BestSellersFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BestSellersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
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
            binding.textView.text = bestSellers.numResults.toString()
            val adapter = BooksAdapter(bestSellers.results)
            binding.booksRV.adapter = adapter
        })
    }
}