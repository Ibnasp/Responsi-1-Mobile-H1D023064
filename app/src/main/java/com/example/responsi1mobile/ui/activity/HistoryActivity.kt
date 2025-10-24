package com.example.responsi1mobile.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobile.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivClubLogo.setImageResource(com.example.responsi1mobile.R.drawable.img)
        binding.tvClubName.text = "RCD Mallorca"
        binding.tvHistory.text = "RCD Mallorca merupakan salah satu klub sepak bola tertua di Spanyol yang berdiri pada tahun 1916 dengan nama awal Alfonso XIII FBC. Klub ini berasal dari pulau Mallorca, yang terletak di Kepulauan Balearic, Spanyol. Sejak awal berdirinya, Mallorca dikenal sebagai klub dengan semangat juang tinggi, mewakili identitas masyarakat pulau yang kuat dan penuh kebanggaan terhadap daerahnya sendiri.\n" +
                "\n" +
                "Perjalanan klub tidak selalu mulus. RCD Mallorca sempat merasakan naik-turun kasta liga Spanyol, mulai dari Segunda División hingga La Liga. Namun, masa kejayaan mereka datang pada akhir 1990-an hingga awal 2000-an, saat berhasil menembus kompetisi Eropa dan bahkan memenangkan Copa del Rey tahun 2003, yang menjadi salah satu momen paling bersejarah dalam sejarah klub.\n" +
                "\n" +
                "Stadion kebanggaan klub ini adalah Visit Mallorca Estadi, yang berlokasi di Palma de Mallorca dan berkapasitas lebih dari 23.000 penonton. Stadion ini menjadi saksi banyak pertandingan emosional, terutama saat Mallorca berjuang melawan klub-klub besar seperti Real Madrid dan Barcelona. Dukungan dari para penggemar, yang dikenal dengan sebutan Los Bermellones, menjadi kekuatan utama tim setiap kali bertanding di kandang.\n" +
                "\n" +
                "Dalam beberapa tahun terakhir, Mallorca terus berusaha memperkuat identitas mereka sebagai klub yang mengandalkan pemain muda dan talenta lokal. Filosofi pengembangan pemain ini membuat klub tetap kompetitif meskipun memiliki sumber daya terbatas dibandingkan klub-klub besar Spanyol lainnya.\n" +
                "\n" +
                "Kini, RCD Mallorca dikenal sebagai simbol ketekunan dan kebanggaan daerah, dengan semangat pantang menyerah yang terus diwariskan dari generasi ke generasi. Klub ini bukan hanya sekadar tim sepak bola, melainkan bagian dari identitas masyarakat Mallorca yang mencerminkan kerja keras, loyalitas, dan semangat untuk terus berkembang."
    }
}