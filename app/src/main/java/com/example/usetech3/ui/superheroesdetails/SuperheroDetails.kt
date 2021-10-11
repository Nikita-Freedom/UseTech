package com.example.usetech3.ui.superheroesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.usetech3.databinding.FragmentSuperheroBiographyBinding


class SuperheroDetails : Fragment() {

    private val viewModel: SuperheroDetailsViewModel by viewModels()

    private lateinit var binding: FragmentSuperheroBiographyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuperheroBiographyBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        arguments?.getInt("id")?.let { viewModel.getSuperhero(it) }
        setObservers(binding)
        return binding.root
    }


    private fun setObservers(binding: FragmentSuperheroBiographyBinding) {
        viewModel.superhero.observe(viewLifecycleOwner) { result ->
            binding.ivBiographyCardImage.load(result.image.url)
            binding.tvName.text = result.name
            binding.tvWork.text = result.work.occupation
            binding.tvFullName.text = result.biography.fullName
            result.biography.aliases.forEach { binding.tvAliases.text = it }
            binding.tvRelatives.text = result.connections.relatives
        }
    }

}