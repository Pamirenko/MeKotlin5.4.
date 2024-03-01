package com.example.mekotlin54.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mekotlin54.data.model.CharactersItems
import com.example.mekotlin54.databinding.ItemBinding

class CharacterAdapters : RecyclerView.Adapter<CharacterAdapters.CharacterViewHolder>() {

    private var characterList = listOf<CharactersItems>()

    fun setCharacter(_characterList: List<Any?>) {
        this.characterList = _characterList as List<CharactersItems>
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(charactersItem: CharactersItems) = with(binding) {
            tvTitle.text = charactersItem.nickname

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount() = characterList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(characterList[position])
    }
}