package com.example.footballapp.favorite

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapp.core.data.source.Resource
import com.example.footballapp.core.ui.TeamAdapter
import com.example.footballapp.databinding.FragmentHomeBinding
import com.example.footballapp.detail.DetailActivity
import com.example.footballapp.favorite.databinding.FragmentFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(favoriteModule)

        if(activity != null){
            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_TEAM, selectedData)
                startActivity(intent)
                binding.progressBar.visibility = View.VISIBLE
            }
            favoriteViewModel.favTeam.observe(viewLifecycleOwner, { dataTeam ->
                binding.rvTeam.visibility = View.VISIBLE
                teamAdapter.setTeam(dataTeam)
                binding.progressBar.visibility = View.GONE
            })
            with(binding.rvTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvTeam.adapter = null
        _binding = null
    }
}