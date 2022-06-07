package com.uasmobile.player_nba.network

import com.squareup.moshi.Json


data class Player(
    val data: List<Data>
){
    data class Data(
        val id :Int,
        @Json(name = "first_name")
        val first_name:String,
        @Json(name = "last_name")
        val last_name:String,
        @Json(name = "position")
        val position:String
    )
}