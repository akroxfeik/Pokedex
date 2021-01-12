package com.tekever.pokemon.model

import com.tekever.pokemon.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeRep {

    fun getPokemonList(limit: Int, offset: Int, onResult: (isSuccess: Boolean, response: PokemonResponse?)-> Unit){

        ApiClient.instance.getPokemons(limit,offset).enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                if(response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                onResult(false, null)
            }

        })
    }


    fun getPokemon(name:String, onResult: (isSuccess: Boolean, response: PokemonDetailResponse?) -> Unit)
    {
        ApiClient.instance.getPokemon(name).enqueue(object : Callback<PokemonDetailResponse> {
            override fun onResponse(call: Call<PokemonDetailResponse>, response: Response<PokemonDetailResponse>) {
                if(response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<PokemonDetailResponse>, t: Throwable) {
                onResult(false, null)
            }

        })
    }

    fun getPokemonSpecies(id:Int, onResult: (isSuccess: Boolean, response: PokemonSpecies?) -> Unit)
    {
        ApiClient.instance.getPokemonSpecies(id).enqueue(object : Callback<PokemonSpecies> {
            override fun onResponse(call: Call<PokemonSpecies>, response: Response<PokemonSpecies>) {
                if(response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<PokemonSpecies>, t: Throwable) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: PokeRep? = null
        fun getInstance() = INSTANCE
            ?: PokeRep().also {
                INSTANCE = it
            }
    }
}