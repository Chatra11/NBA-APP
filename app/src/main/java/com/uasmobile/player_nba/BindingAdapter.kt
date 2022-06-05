package com.uasmobile.player_nba

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uasmobile.player_nba.network.Team
import com.uasmobile.player_nba.ui.TeamListAdapter


@BindingAdapter("ListTeam")
fun bindRecylerView(recyclerView: RecyclerView,data:List<Team.Data>?){
    val adapter = recyclerView.adapter as TeamListAdapter
    adapter.submitList(data)
}