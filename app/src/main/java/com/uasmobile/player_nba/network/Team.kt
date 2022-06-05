package com.uasmobile.player_nba.network

import com.squareup.moshi.Json

data class Team(
    val data: List<Data>
){
    data class Data(
        val id :Int,
        val abbreviation:String,
        val city:String,
        val conference:String,
        val division:String,
        @Json(name = "full_name")
        val full_name:String,
        val name: String
    )
}