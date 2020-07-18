package com.example.tennis.domain

import com.example.tennis.domain.entities.GameScore
import com.example.tennis.domain.entities.Player
import com.example.tennis.domain.entities.Scores.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TennisGameTest {

    private lateinit var tennisGame : TennisGame

    @Before
    fun setup(){
        tennisGame = TennisGame()
    }

    @Test
    fun `Player two's score should increase correctly each time they score while their opponent does not`(){
        assertEquals(score_0_15, tennisGame.updatePlayerTwoScore(tennisGame.gameScore.playerTwo))
        assertEquals(score_0_30, tennisGame.updatePlayerTwoScore(tennisGame.gameScore.playerTwo))
        assertEquals(score_0_40, tennisGame.updatePlayerTwoScore(tennisGame.gameScore.playerTwo))
        assertEquals(score_lose_win, tennisGame.updatePlayerTwoScore(tennisGame.gameScore.playerTwo))
    }

    companion object {
        private val score_0_15 = GameScore(Player(ZERO),Player(FIFTEEN))
        private val score_0_30 = GameScore(Player(ZERO),Player(THIRTY))
        private val score_0_40 = GameScore(Player(ZERO),Player(FORTY))
        private val score_lose_win = GameScore(Player(ZERO), Player(WIN))
    }
}
