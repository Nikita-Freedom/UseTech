package com.example.usetech3.ui.superheroeslist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usetech3.R
import com.example.usetech3.databinding.FragmentSuperheroesBinding
import timber.log.Timber


class Superheroes : Fragment() {

    private val viewModel: SuperheroesViewModel by viewModels()
    private lateinit var binding: FragmentSuperheroesBinding

    @SuppressLint("TimberArgCount")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuperheroesBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.rvSuperheroes.layoutManager = LinearLayoutManager(context)
        binding.rvSuperheroes.adapter = SuperheroesPreviewAdapter(
            SuperheroesPreviewAdapter.OnClickListener {
                val bundle = bundleOf("id" to it.id.toInt())
                findNavController().navigate(R.id.action_superheroes_to_biography, bundle)
                Timber.d("idLogger", it.id)
            }
        )
        setObservers(binding)
        viewModel.getSuperheroes(" ")
        binding.etSearchByName.addTextChangedListener {
            viewModel.getSuperheroes(binding.etSearchByName.text.toString())
            if (binding.etSearchByName.text.toString() != "") {
                binding.tvLetsStart.visibility = View.GONE
            } else {
                binding.tvLetsStart.visibility = View.VISIBLE

            }
        }

        binding.ivSearch.setOnClickListener {
            viewModel.getSuperheroes(binding.etSearchByName.text.toString())

        }

        return binding.root
    }

    private fun setObservers(binding: FragmentSuperheroesBinding) {
        Timber.d("Observing")
        viewModel.superheroes.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                (binding.rvSuperheroes.adapter as SuperheroesPreviewAdapter).data =
                    viewModel.superheroes.value!!
            } else {
                (binding.rvSuperheroes.adapter as SuperheroesPreviewAdapter).data = emptyList()
            }
        }
    }

}
