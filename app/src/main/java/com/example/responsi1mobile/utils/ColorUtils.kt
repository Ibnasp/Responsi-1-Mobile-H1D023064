package com.example.responsi1mobile.utils

import android.graphics.Color

object ColorUtils {
    fun forPosition(position: String?): Int {
        val p = position?.lowercase()?.trim()
        return when {
            p == null -> Color.LTGRAY
            p.contains("goal") || p.contains("keeper") -> Color.parseColor("#FFF176") // kuning
            p.contains("defen") || p.contains("back") -> Color.parseColor("#64B5F6") // biru
            p.contains("mid") -> Color.parseColor("#81C784") // hijau
            p.contains("forw") || p.contains("att") || p.contains("striker") -> Color.parseColor("#E57373") // merah
            else -> Color.LTGRAY
        }
    }
}