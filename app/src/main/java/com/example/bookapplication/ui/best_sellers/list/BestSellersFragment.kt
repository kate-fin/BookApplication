package com.example.bookapplication.ui.best_sellers.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bookapplication.R
import com.example.bookapplication.databinding.FragmentBestSellersBinding
import com.example.bookapplication.extensions.appComponent
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import javax.inject.Inject

class BestSellersFragment : Fragment() {
    private var _binding: FragmentBestSellersBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BestSellersViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.appComponent?.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[BestSellersViewModel::class.java]
        viewModel.getBestSellers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBestSellersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdMob()
        viewModel.spinner.observe(viewLifecycleOwner, { isLoading ->
            if (isLoading) {
                binding.bestSellersPrBar.visibility = View.VISIBLE
            } else {
                binding.bestSellersPrBar.visibility = View.GONE
            }
        })

        viewModel.error.observe(viewLifecycleOwner, { isError ->
            if (isError) {
                binding.bestSellersPrBar.visibility = View.GONE
                Toast.makeText(context, getString(R.string.error_message), Toast.LENGTH_SHORT)
                    .show()
            }
        })

        viewModel.bestSellersLiveData.observe(viewLifecycleOwner, { bestSellers ->
            val adapter = BooksAdapter(bestSellers)
            binding.bestSellersRecView.adapter = adapter
        })

        binding.bestSellerToolbar.settings.setOnClickListener {
            findNavController().navigate(BestSellersFragmentDirections.actionBestSellersFragmentToSettingsFragment())
        }
    }

    private fun initAdMob() {
        MobileAds.initialize(this.requireContext())
        val adRequest = AdManagerAdRequest.Builder().build()
        binding.bestSellersAdView.loadAd(adRequest)
    }

    override fun onResume() {
        super.onResume()
        binding.bestSellersAdView.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.bestSellersAdView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.bestSellersAdView.destroy()
    }
}