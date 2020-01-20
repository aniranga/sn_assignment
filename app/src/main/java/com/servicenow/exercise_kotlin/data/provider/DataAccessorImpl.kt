package com.servicenow.exercise_kotlin.data.provider

import android.app.Application
import com.servicenow.resources.Game
import com.servicenow.resources.NESGames
import io.reactivex.Observer

class DataAccessorImpl(val app: Application) : DataAccessor {

    override fun getGamesList(callback: Observer<ArrayList<Game>>) {
        var resultList: ArrayList<Game> = ArrayList()
        for (game in NESGames.list) {
            resultList.add(game);
        }
    }
}