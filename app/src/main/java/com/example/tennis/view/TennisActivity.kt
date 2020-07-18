package com.example.tennis.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.tennis.R
import com.example.tennis.controller.TennisController
import com.example.tennis.databinding.LayoutTennisBinding
import com.example.tennis.library.controllers
import com.example.tennis.viewmodel.TennisViewModel
import kotlinx.android.synthetic.main.activity_tennis.*
import kotlinx.android.synthetic.main.layout_tennis.*

class TennisActivity : AppCompatActivity() {

    private val viewModel : TennisViewModel by viewModels()
    private val controller : TennisController by controllers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tennis)
        setupGame()
        setupClickListeners()
    }

    private fun setupGame(){
        val binding = LayoutTennisBinding.inflate(layoutInflater)
        binding.game = viewModel
        game_container.addView(binding.root)
        controller.createGame()
    }

    private fun setupClickListeners(){
        button_player_one.setOnClickListener { controller.addPointForPlayerOne() }
        button_player_two.setOnClickListener { controller.addPointForPlayerTwo() }
        button_reset.setOnClickListener{ controller.resetGame() }
    }
}
