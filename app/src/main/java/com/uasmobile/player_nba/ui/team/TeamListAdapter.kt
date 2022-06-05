package com.uasmobile.player_nba.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uasmobile.player_nba.databinding.ListTeamBinding
import com.uasmobile.player_nba.network.Team

class TeamListAdapter (private val clickListener: TeamListener):
        ListAdapter<Team.Data, TeamListAdapter.TeamViewHolder>(DiffCallback)
{
            class TeamViewHolder(
                var binding: ListTeamBinding
            ): RecyclerView.ViewHolder(binding.root){
                fun bind(clickListener: TeamListener?, team: Team.Data){
                    binding.team = team
                    binding.clickListener = clickListener
                    binding.executePendingBindings()
                }
            }

    companion object DiffCallback: DiffUtil.ItemCallback<Team.Data>(){
        override fun areContentsTheSame(oldItem: Team.Data, newItem: Team.Data): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areItemsTheSame(oldItem: Team.Data, newItem: Team.Data): Boolean {
            return oldItem.name == newItem.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TeamViewHolder(
            ListTeamBinding.inflate(layoutInflater,parent,false)
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(clickListener,team)
    }

}
class TeamListener(val clickListener: (team:Team.Data)-> Unit){
    fun onClick(team: Team.Data) = clickListener(team)
}