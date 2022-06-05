package com.uasmobile.player_nba.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.uasmobile.player_nba.R
import com.uasmobile.player_nba.databinding.FragmentListTeamBinding
import com.uasmobile.player_nba.ui.MyViewModel
import com.uasmobile.player_nba.ui.TeamListAdapter
import com.uasmobile.player_nba.ui.TeamListener

class FragmentListTeam: Fragment() {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListTeamBinding.inflate(inflater)
        viewModel.getTeamData()
        binding.lifecycleOwner = this
        binding.vievModel = viewModel
        binding.recyclerView.adapter = TeamListAdapter(TeamListener { team ->
            viewModel.onTeamClicked(team)
            findNavController()
                .navigate(R.id.action_teamListFragment_to_teamDetailFragment)
        })
        return  binding.root

    }

}