package com.example.responsi1mobile.data.model

data class TeamResponse(
    val id: Int? = null,
    val name: String? = null,
    val founded: Int? = null,
    val venue: String? = null,
    val coach: Coach? = null,
    val squad: List<Player>? = null
)
