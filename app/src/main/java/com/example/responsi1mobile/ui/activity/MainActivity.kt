package com.example.responsi1mobile.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.responsi1mobile.databinding.ActivityMainBinding
import com.example.responsi1mobile.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.fetchTeam()
        vm.team.observe(this) { team ->
            if (team != null) {
                binding.tvClubName.text = "89. ${team.name ?: "-"}"
                // set banner/logo
                Glide.with(this).load(team.crest).into(binding.imgLogo)
                // description left as static or replace:
                // binding.tvDescription.text = "..." // if you want to update dynamically
            } else {
                binding.tvClubName.text = "Error loading team"
            }
        }

        binding.cardHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        binding.cardCoach.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }
        binding.cardSquad.setOnClickListener {
            startActivity(Intent(this, SquadActivity::class.java))
        }
    }
}