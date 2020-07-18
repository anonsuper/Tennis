package com.example.tennis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tennis.*

class TennisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tennis)
        layoutInflater.inflate(R.layout.layout_tennis, game_container)
    }
}
