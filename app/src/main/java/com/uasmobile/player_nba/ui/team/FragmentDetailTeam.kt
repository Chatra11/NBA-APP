package com.uasmobile.player_nba.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.uasmobile.player_nba.R
import com.uasmobile.player_nba.databinding.FragmentDetailTeamBinding
import com.uasmobile.player_nba.ui.MyViewModel

class FragmentDetailTeam :Fragment(){
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailTeamBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->findNavController().navigate(R.id.action_TeamDetailFragment_to_TeamListFragment)
        }
        return true
    }
}