package com.uasmobile.player_nba.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uasmobile.player_nba.network.Player
import com.uasmobile.player_nba.network.PlayerApi
import kotlinx.coroutines.launch

class MyViewModel2  : ViewModel(){

    private val _player = MutableLiveData<Player>()
    val player : LiveData<Player> = _player

    private val _detailPlayer =MutableLiveData<Player.Data>()
    val  detail: LiveData<Player.Data> = _detailPlayer

    init {
        getPlayerData()
    }

    fun getPlayerData(){
        viewModelScope.launch {
            try {
                _player.value = PlayerApi.retrofitServiceApi.getData()
                Log.d("berhasil",player.value.toString())
            }catch (e:Exception){
                _player.value = Player(listOf())
            }
        }
    }
    fun onPlayerClicked(player: Player.Data){
        _detailPlayer.value = player
    }
}