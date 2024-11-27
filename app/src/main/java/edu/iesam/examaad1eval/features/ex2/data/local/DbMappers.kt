package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.Game

class DbMappers {

    fun toGameEntity(game: Game): GameEntity {
        return GameEntity(
            id = game.id,
            title = game.title,
            player = game.player
        )
    }

    fun toGameModel(gameEntity: GameEntity): Game {
        return Game(
            id = gameEntity.id,
            title = gameEntity.title ?: "",
            player = gameEntity.player
        )
    }
}