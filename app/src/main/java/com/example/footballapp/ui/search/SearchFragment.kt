package com.example.footballapp.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapp.core.domain.model.Team
import com.example.footballapp.core.ui.TeamAdapter
import com.example.footballapp.databinding.FragmentSearchBinding
import com.example.footballapp.detail.DetailActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModel()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        searchClick()
        return binding.root
    }

    private fun searchClick(){
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val searchAdapter = TeamAdapter()
                searchAdapter.onItemClick = { selectedData ->
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TEAM, selectedData)
                    startActivity(intent)
                }
                searchViewModel.search(query!!).observe(viewLifecycleOwner, { search ->
                    Log.d("SEARCH", search.toString())
                    if(search != null){
                        binding.search.visibility = View.GONE
                        searchAdapter.setTeam(search)
                        searchAdapter.notifyDataSetChanged()
                    }
                })

                with(binding.rvTeam){
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = searchAdapter
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.searchView.setOnQueryTextListener(null)
        binding.rvTeam.adapter = null
        _binding = null
    }
}