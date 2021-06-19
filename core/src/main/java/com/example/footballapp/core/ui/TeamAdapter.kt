package com.example.footballapp.core.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballapp.core.R
import com.example.footballapp.core.databinding.ItemTeamBinding
import com.example.footballapp.core.domain.model.Team

class TeamAdapter: RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    private var listTeam = ArrayList<Team>()
    var onItemClick: ((Team) -> Unit)? = null

    fun setTeam(team: List<Team>?) {
        if(team == null) return
        listTeam.clear()
        listTeam.addAll(team)
        notifyDataSetChanged()
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTeamBinding.bind(itemView)
        fun bind(team: Team){
            with(binding) {
                tvName.text = team.teamName
                tvLocation.text = team.location
                tvStadiumName.text = team.stadium
                Glide.with(itemView.context)
                    .load(team.stadiumImage)
                    .centerCrop()
                    .into(ivStadium)
                Glide.with(itemView.context)
                    .load(team.teamCrest)
                        .centerCrop()
                        .into(ivCrest)
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listTeam[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.TeamViewHolder =
            TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false))

    override fun onBindViewHolder(holder: TeamAdapter.TeamViewHolder, position: Int) {
        val teams = listTeam[position]
        holder.bind(teams)
    }

    override fun getItemCount(): Int {
        return listTeam.size
    }

}