package com.example.responsi1mobile.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobile.R
import com.example.responsi1mobile.databinding.ActivityCoachBinding
import com.example.responsi1mobile.viewmodel.MainViewModel

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivCoach.setImageResource(R.drawable.coach)

        vm.team.observe(this) { team ->
            val coach = team?.coach
            if (coach != null) {
                binding.tvCoachName.text = coach.name ?: "-"
                binding.tvCoachNation.text = coach.nationality ?: "-"
            } else {
                binding.tvCoachName.text = "Coach data unavailable"
                binding.tvCoachNation.text = "-"
            }
        }
        vm.fetchTeam()
    }
}