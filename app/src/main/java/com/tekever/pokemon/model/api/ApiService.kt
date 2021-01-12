package com.tekever.pokemon.model.api

import com.tekever.pokemon.model.PokemonDetailResponse
import com.tekever.pokemon.model.PokemonResponse
import com.tekever.pokemon.model.PokemonSpecies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    fun getPokemons(@Query("limit") limit: Int, @Query("offset") offset:Int): Call<PokemonResponse>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name")name: String) : Call<PokemonDetailResponse>

    @GET("pokemon-species/{id}")
    fun getPokemonSpecies(@Path("id") id: Int) : Call<PokemonSpecies>
}