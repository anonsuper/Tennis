package com.example.tennis.domain

import com.example.tennis.domain.entities.GameScore
import com.example.tennis.domain.entities.Player
import com.example.tennis.domain.entities.Scores.*

class TennisGame(val gameScore : GameScore = GameScore()){

    fun updatePlayerTwoScore(player: Player) : GameScore {
        player.score = when (player.score){
            ZERO -> FIFTEEN
            FIFTEEN -> THIRTY
            THIRTY -> FORTY
            FORTY -> WIN
            WIN -> WIN
            LOSE -> LOSE
        }
        return gameScore
    }

}
