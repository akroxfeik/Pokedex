package com.tekever.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tekever.pokemon.databinding.ViewPokemonListItemBinding
import com.tekever.pokemon.model.PokemonItem
import com.tekever.pokemon.view.adapter.viewHolders.PokemonListViewHolder
import com.tekever.pokemon.view.ui.pokelist.MainViewModel

class PokemonListAdapter(private val pokemonListViewModel: MainViewModel) : RecyclerView.Adapter<PokemonListViewHolder>(){
    var pokemonList: List<PokemonItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewPokemonListItemBinding.inflate(inflater, parent, false)
        return PokemonListViewHolder(dataBinding, pokemonListViewModel)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.setup(pokemonList[position])
    }

    fun updatePokemonList(pokemonList: List<PokemonItem>){
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}