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
        assertEquals(score_0_15, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
        assertEquals(score_0_30, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
        assertEquals(score_0_40, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
        assertEquals(score_lose_win, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
    }

    @Test
    fun `Player one's score should increase correctly each time they score while their opponent is also scoring`() {
        assertEquals(score_0_15, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
        assertEquals(score_0_30, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
        assertEquals(score_0_40, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
        assertEquals(score_15_40, tennisGame.updatePlayerScore(tennisGame.gameScore.playerOne,tennisGame.gameScore.playerTwo))
        assertEquals(score_30_40, tennisGame.updatePlayerScore(tennisGame.gameScore.playerOne,tennisGame.gameScore.playerTwo))
        assertEquals(score_40_40, tennisGame.updatePlayerScore(tennisGame.gameScore.playerOne,tennisGame.gameScore.playerTwo))
        assertEquals(score_40_adv, tennisGame.updatePlayerScore(tennisGame.gameScore.playerTwo,tennisGame.gameScore.playerOne))
        assertEquals(score_40_40, tennisGame.updatePlayerScore(tennisGame.gameScore.playerOne,tennisGame.gameScore.playerTwo))
        assertEquals(score_adv_40, tennisGame.updatePlayerScore(tennisGame.gameScore.playerOne,tennisGame.gameScore.playerTwo))
        assertEquals(score_win_lose, tennisGame.updatePlayerScore(tennisGame.gameScore.playerOne,tennisGame.gameScore.playerTwo))
    }

    companion object {
        private val score_0_15 = GameScore(Player(ZERO),Player(FIFTEEN))
        private val score_0_30 = GameScore(Player(ZERO),Player(THIRTY))
        private val score_0_40 = GameScore(Player(ZERO),Player(FORTY))
        private val score_lose_win = GameScore(Player(LOSE), Player(WIN))
        private val score_15_40 = GameScore(Player(FIFTEEN), Player(FORTY))
        private val score_30_40 = GameScore(Player(THIRTY), Player(FORTY))
        private val score_40_40 = GameScore(Player(FORTY), Player(FORTY))
        private val score_40_adv = GameScore(Player(FORTY),Player(ADVANTAGE))
        private val score_adv_40 = GameScore(Player(ADVANTAGE), Player(FORTY))
        private val score_win_lose = GameScore(Player(WIN), Player(LOSE))
    }
}
