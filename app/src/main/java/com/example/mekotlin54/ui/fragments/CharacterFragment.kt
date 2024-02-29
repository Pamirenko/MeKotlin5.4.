package com.example.mekotlin54.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mekotlin54.databinding.FragmentCharacterBinding
import com.example.mekotlin54.ui.adapters.CharacterAdapters


class CharacterFragment : Fragment() {


    private var _binding: FragmentCharacterBinding? = null
    private val binding: FragmentCharacterBinding get() = _binding!!
    private val adapter = CharacterAdapters()
    private val viewModel by viewModels<CharacterViewModel<Any?>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
        initialize()
    }

    private fun subscribe() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) {
            Log.e("bleach", "subscribe: ${it.success}")
            adapter.setCharacter(it.success!!)
        }
    }

    private fun initialize() = with(binding) {
        rvCharacter.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}