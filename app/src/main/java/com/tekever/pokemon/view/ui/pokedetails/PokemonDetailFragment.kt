package com.tekever.pokemon.view.ui.pokedetails

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.tekever.pokemon.databinding.PokemonDetailFragmentBinding
import com.tekever.pokemon.view.adapter.AbilityListAdapter
import com.tekever.pokemon.view.adapter.MoveListAdapter
import com.tekever.pokemon.view.adapter.PokeDexListAdapter
import com.tekever.pokemon.view.adapter.PokemonListAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.pokemon_detail_fragment.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.padding
import org.jetbrains.anko.textColor

class PokemonDetailFragment : Fragment() {
    private lateinit var viewDataBinding: PokemonDetailFragmentBinding
    private lateinit var adapterMoves: MoveListAdapter
    private lateinit var adapterAbilities: AbilityListAdapter
    private lateinit var adapterPokeDex: PokeDexListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = PokemonDetailFragmentBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@PokemonDetailFragment).get(PokemonViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.let { PokemonDetailFragmentArgs.fromBundle(it).name }
        viewDataBinding.viewmodel?.fetchPokemon(name!!)

        setupAdapterMoves()
        setupAdapterAbilities()
        setupAdapterPokeDex()
        setupObservers()
    }

    private fun setupAdapterMoves() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapterMoves = MoveListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            rvMoves.layoutManager = layoutManager
            rvMoves.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            rvMoves.adapter = adapterMoves
        }
    }

    private fun setupAdapterAbilities() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapterAbilities = AbilityListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            rvAbilities.layoutManager = layoutManager
            rvAbilities.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            rvAbilities.adapter = adapterAbilities
        }
    }

    private fun setupAdapterPokeDex() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapterPokeDex = PokeDexListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            rvPDex.layoutManager = layoutManager
            rvPDex.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            rvPDex.adapter = adapterPokeDex
        }
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.pokemon?.observe(viewLifecycleOwner, Observer {
            Picasso.get().load(it?.sprites?.front_default).into(ivDefault)
            Picasso.get().load(it?.sprites?.front_shiny).into(ivShiny)

            for(type in it?.types!!)
            {
                val lp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)

                lp.topMargin = 10
                lp.leftMargin = 10

                val tv : TextView = TextView(this.context)
                tv.text = type.type.name.capitalize()
                tv.backgroundColor = Color.parseColor(checkColor(type.type.name))
                tv.padding = 10
                tv.textColor = Color.parseColor("#FFFFFF")

                llType.addView(tv, lp)
            }
            adapterMoves.updateMoveList(it?.moves)
            adapterAbilities.updateAbilityList(it?.abilities)
        })

        viewDataBinding.viewmodel?.species?.observe(viewLifecycleOwner, Observer {
            adapterPokeDex.updatePokeDexList(it?.pokedex_numbers!!)
        })
    }

    private fun checkColor(type: String) : String
    {
        return when (type) {
            "normal" -> "#A8A878"
            "fighting" -> "#C03028"
            "flying" -> "#A890F0"
            "poison" -> "#A040A0"
            "ground" -> "#E0C068"
            "rock" -> "#B8A038"
            "bug" -> "#A8B820"
            "ghost" -> "#705898"
            "steel" -> "#B8B8D0"
            "fire" -> "#F08030"
            "water" -> "#6890F0"
            "grass" -> "#78C850"
            "electric" -> "#F8D030"
            "psychic" -> "#F85888"
            "ice" -> "#98D8D8"
            "dragon" -> "#7038F8"
            "dark" -> "#705848"
            "fairy" -> "#EE99AC"
            else -> "#A8A878"
        }
    }
}