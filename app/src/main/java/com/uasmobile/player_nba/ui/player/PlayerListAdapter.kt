package com.uasmobile.player_nba.ui.player

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uasmobile.player_nba.databinding.ListPlayerBinding
import com.uasmobile.player_nba.network.Player

class PlayerListAdapter (private val clickListener: PlayerListener):
    ListAdapter<Player.Data, PlayerListAdapter.PlayerViewHolder>(DiffCallback)
{
    class PlayerViewHolder(
        var binding: ListPlayerBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: PlayerListener?, player: Player.Data){
            binding.player = player
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Player.Data>(){
        override fun areContentsTheSame(oldItem: Player.Data, newItem: Player.Data): Boolean {
            return oldItem.first_name == newItem.first_name
        }
        override fun areItemsTheSame(oldItem: Player.Data, newItem: Player.Data): Boolean {
            return oldItem.first_name == newItem.first_name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlayerViewHolder(
            ListPlayerBinding.inflate(layoutInflater,parent,false)
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(clickListener,player)
    }

}
class PlayerListener(val clickListener: (player:Player.Data)-> Unit){
    fun onClick(player: Player.Data) = clickListener(player)
}