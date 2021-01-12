package com.tekever.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tekever.pokemon.databinding.ViewMoveListItemBinding
import com.tekever.pokemon.model.PokemonMove
import com.tekever.pokemon.view.adapter.viewHolders.MoveListViewHolder
import com.tekever.pokemon.view.ui.pokedetails.PokemonViewModel

class MoveListAdapter(private val pokemonListViewModel: PokemonViewModel) : RecyclerView.Adapter<MoveListViewHolder>(){
    var pokemonList: List<PokemonMove> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewMoveListItemBinding.inflate(inflater, parent, false)
        return MoveListViewHolder(dataBinding, pokemonListViewModel)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: MoveListViewHolder, position: Int) {
        holder.setup(pokemonList[position])
    }

    fun updateMoveList(pokemonList: List<PokemonMove>){
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}