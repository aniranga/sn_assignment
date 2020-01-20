package com.servicenow.exercise_kotlin.gameslist

import com.servicenow.resources.Game
import com.servicenow.resources.NESGames

class GameListPresenterImpl(val gameListView: GameListView): GameListPresenter {

    private var resultList : ArrayList<Game> = ArrayList()

    override fun fetchItems() {
        for (game in NESGames.list) {
            resultList.add(game);
        }
        gameListView.onFetchedAllItems(resultList)

    }

    override fun destroy() {

    }
}