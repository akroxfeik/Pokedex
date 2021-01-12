package com.tekever.pokemon.model

data class PokemonResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: MutableList<PokemonItem>
)

data class PokemonItem(
    val name: String,
    val url: String
)

data class PokemonDetailResponse(
    val id: Int,
    val base_experience: Int,
    val name: String,
    val order: Int,
    val weight: Int,
    val sprites: PokemonSprites,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>,
    val moves: List<PokemonMove>,
    val abilities: List<PokemonAbility>
)

data class PokemonSprites(
    val front_default: String,
    val front_shiny: String
)

data class PokemonStat(
    val base_stat: Int,
    val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String
)

data class PokemonType(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String
)

data class PokemonMove(
    val move: Move
)

data class Move(
    val name: String
)

data class PokemonAbility(
    val ability: Ability,
    val is_hidden: Boolean
)

data class Ability(
    val name: String
)

data class PokemonSpecies(
    val base_happiness: Int,
    val capture_rate: Int,
    val pokedex_numbers: List<PokemonPokeDexNumber>
)

data class PokemonPokeDexNumber(
    val entry_number: Int,
    val pokedex: PokeDexNumber
)

data class PokeDexNumber(
    val name: String
)