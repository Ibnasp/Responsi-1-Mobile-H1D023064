package com.example.responsi1mobile.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobile.databinding.ActivitySquadBinding
import com.example.responsi1mobile.ui.adapter.PlayerAdapter
import com.example.responsi1mobile.viewmodel.MainViewModel

class SquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySquadBinding
    private val vm: MainViewModel by viewModels()
    private lateinit var adapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PlayerAdapter(emptyList())
        binding.rvPlayers.layoutManager = LinearLayoutManager(this)
        binding.rvPlayers.adapter = adapter

        vm.team.observe(this) { t ->
            val players = t?.squad ?: emptyList()
            adapter.setData(players)
        }

        vm.fetchTeam()
    }
}