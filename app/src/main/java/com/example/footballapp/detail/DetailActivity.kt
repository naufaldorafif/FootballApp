package com.example.footballapp.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.widget.ToolbarWidgetWrapper
import com.bumptech.glide.Glide
import com.example.footballapp.R
import com.example.footballapp.core.domain.model.Team
import com.example.footballapp.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEAM = "extra_team"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailTeam = intent.getParcelableExtra<Team>(EXTRA_TEAM)

        supportActionBar?.title = detailTeam?.teamName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showDetailTeam(detailTeam)

    }

    private fun showDetailTeam(detailTeam: Team?){
        binding.progressBar.visibility = View.GONE
        detailTeam?.let {
            binding.tvFormed.text = detailTeam.formed.toString()
            binding.tvComp1.text = "Competition 1: ${detailTeam.league1}"
            binding.tvComp2.text = "Competition 2: ${detailTeam.league2}"
            binding.tvComp3.text = "Competition 3: ${detailTeam.league3}"
            binding.tvLocation.text = detailTeam.location
            binding.tvStadiumName.text = detailTeam.stadium
            binding.tvOverview.text = detailTeam.description
            binding.tvStadiumDesc.text = detailTeam.stadiumDesc
            Glide.with(this)
                    .load(detailTeam.stadiumImage)
                    .centerCrop()
                    .into(binding.ivImageStadium)
            Glide.with(this)
                    .load(detailTeam.teamCrest)
                    .into(binding.ivImage)
            var statusFavorite = detailTeam.favorite
            setFavorite(statusFavorite)
            binding.fabFavorites.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteTeam(detailTeam, statusFavorite)
                setFavorite(statusFavorite)
            }
        }
    }

    private fun setFavorite(state: Boolean){
        if(state){
            binding.fabFavorites.setColorFilter(Color.RED)
        }else {
            binding.fabFavorites.setColorFilter(Color.WHITE)
        }
    }
}