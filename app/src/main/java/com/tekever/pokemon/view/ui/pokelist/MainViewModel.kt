package com.tekever.pokemon.view.ui.pokelist

import androidx.lifecycle.MutableLiveData
import com.tekever.pokemon.model.PokeRep
import com.tekever.pokemon.model.PokemonItem
import com.tekever.pokemon.utils.Constants.Companion.QUERY_PAGE_SIZE
import com.tekever.pokemon.view.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    val pokeListLive = MutableLiveData<MutableList<PokemonItem>>()
    val limit: Int = QUERY_PAGE_SIZE
    var offset: Int = 0

    fun fetchPokemonList()
    {
        dataLoading.value = true
        PokeRep.getInstance().getPokemonList (limit, offset) { isSuccess, response ->
            dataLoading.value = false
            if(isSuccess){
                if(offset + limit < response?.count!!)
                    offset += limit
                if(pokeListLive == null || pokeListLive.value == null)
                {
                    pokeListLive.value = response?.results
                }
                else
                {
                    pokeListLive.value?.addAll(response?.results)
                }

                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}