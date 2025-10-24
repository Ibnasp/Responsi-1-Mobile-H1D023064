package com.example.responsi1mobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobile.data.model.TeamResponse
import com.example.responsi1mobile.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _team = MutableLiveData<TeamResponse?>()
    val team: LiveData<TeamResponse?> = _team

    fun fetchTeam() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTeamData()
                if (response.isSuccessful) {
                    _team.value = response.body()
                    println("✅ Team loaded: ${response.body()?.name}")
                } else {
                    println("❌ Error response: ${response.code()}")
                    _team.value = null
                }
            } catch (e: Exception) {
                println("⚠️ Exception: ${e.message}")
                _team.value = null
            }
        }
    }
}