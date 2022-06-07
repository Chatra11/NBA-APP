package com.uasmobile.player_nba.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.balldontlie.io/api/v1/"

private const val BASE_URL2 = "https://www.balldontlie.io/api/v1/players"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NbaServiceApi{
    @GET("teams")
    suspend fun getData(): Team
}

private val retrofit2 = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL2)
    .build()

interface PlayerServiceApi {
    @GET("player")
    suspend fun getData(): Player
}

object NbaApi {
    val retrofitServiceApi: NbaServiceApi by lazy {
        retrofit.create(NbaServiceApi::class.java)
    }
}

object PlayerApi {
    val retrofitServiceApi: PlayerServiceApi by lazy {
        retrofit.create(PlayerServiceApi::class.java)
    }
}




