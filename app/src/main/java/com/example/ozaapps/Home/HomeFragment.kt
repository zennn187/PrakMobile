package com.example.ozaapps.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.ozaapps.Data.API.CatFactApiClient
import com.example.ozaapps.Home.Pertemuan13.ThirteenthActivity
import com.example.ozaapps.Home.Pertemuan_10.TenthActivity
import com.example.ozaapps.Home.Pertemuan_9.NinthActivity
import com.example.ozaapps.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn9.setOnClickListener {
            startActivity(
                Intent(requireContext(), NinthActivity::class.java)
            )
        }

        binding.btn10.setOnClickListener {
            startActivity(
                Intent(requireContext(), TenthActivity::class.java)
            )
        }

        binding.btn13.setOnClickListener {
            startActivity(
                Intent(requireContext(), ThirteenthActivity::class.java)
            )
        }

        loadCatFact()
    }

    private fun loadCatFact() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}