package com.uasmobile.player_nba

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uasmobile.player_nba.network.Player
import com.uasmobile.player_nba.network.Team
import com.uasmobile.player_nba.ui.TeamListAdapter
import com.uasmobile.player_nba.ui.player.PlayerListAdapter


@BindingAdapter("ListTeam")
fun bindRecylerView(recyclerView: RecyclerView,data:List<Team.Data>?){
    val adapter = recyclerView.adapter as TeamListAdapter
    adapter.submitList(data)
}
@BindingAdapter("ListPlayer")
fun bindRecyclerView(recyclerView: RecyclerView,Data:List<Player.Data>){
    val adapter = recyclerView.adapter as PlayerListAdapter
    adapter.submitList(Data)
}