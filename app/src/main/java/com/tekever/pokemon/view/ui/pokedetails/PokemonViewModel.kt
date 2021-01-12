package com.tekever.pokemon.view.ui.pokedetails

import androidx.lifecycle.MutableLiveData
import com.tekever.pokemon.model.PokeRep
import com.tekever.pokemon.model.PokemonDetailResponse
import com.tekever.pokemon.model.PokemonSpecies
import com.tekever.pokemon.view.base.BaseViewModel

class PokemonViewModel : BaseViewModel() {
    var pokemon = MutableLiveData<PokemonDetailResponse>()
    var species = MutableLiveData<PokemonSpecies>()

    fun fetchPokemon(name: String)
    {
        dataLoading.value = true
        PokeRep.getInstance().getPokemon(name) {isSuccess, response ->
            dataLoading.value = false
            if(isSuccess){
                pokemon.value = response

                PokeRep.getInstance().getPokemonSpecies(response?.id!!) {isSuccess, response ->
                    if(isSuccess) {
                        species.value = response
                    }
                }
            }
        }
    }
}