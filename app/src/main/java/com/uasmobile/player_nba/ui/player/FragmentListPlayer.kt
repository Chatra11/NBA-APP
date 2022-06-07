package com.uasmobile.player_nba.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.uasmobile.player_nba.R
import com.uasmobile.player_nba.databinding.FragmentListPlayerBinding
import com.uasmobile.player_nba.ui.MyViewModel2

class FragmentListPlayer: Fragment() {
    private val viewModel: MyViewModel2 by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListPlayerBinding.inflate(inflater)
        viewModel.getPlayerData()
        binding.lifecycleOwner = this
        binding.vievModel = viewModel
        binding.recyclerView.adapter = PlayerListAdapter(PlayerListener {player->
            viewModel.onPlayerClicked(player)
            findNavController()
                .navigate(R.id.action_PlayerListFragment_to_PlayerDetailFragment)
        })
        return  binding.root

    }

}