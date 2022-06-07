package com.uasmobile.player_nba.network

import com.squareup.moshi.Json


data class Player(
    val data: List<Data>
){
    data class Data(
        val id :Int,
        @Json(name = "first_name")
        val first_name:String,
        @Json(name = "height_feet")
        val height_feet:Int? = null,
        @Json(name = "height_inches")
        val height_inches:Int? = null,
        @Json(name = "last_name")
        val last_name:String,
        val position:String,
        val team: List<Team.Data>,
        @Json(name = "height_inches")
        val weight_pounds:Int? = null,

    )
}