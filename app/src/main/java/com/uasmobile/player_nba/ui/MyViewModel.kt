package com.uasmobile.player_nba.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uasmobile.player_nba.network.NbaApi
import com.uasmobile.player_nba.network.Team
import kotlinx.coroutines.launch

class MyViewModel : ViewModel(){

    private val _team = MutableLiveData<Team>()
    val team : LiveData<Team> = _team

    private val _detailTeam = MutableLiveData<Team.Data>()
    val detail: LiveData<Team.Data> = _detailTeam

    init {
        getTeamData()
    }

    fun getTeamData(){
        viewModelScope.launch {
            try {
                _team.value = NbaApi.retrofitServiceApi.getData()
                Log.d("berhasil",team.value.toString())
            }catch (e:Exception){
                _team.value =  Team(listOf())
            }
        }
    }
    fun onTeamClicked(team: Team.Data){
        _detailTeam.value = team
    }
}