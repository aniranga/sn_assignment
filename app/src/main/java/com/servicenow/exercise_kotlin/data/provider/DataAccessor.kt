package com.servicenow.exercise_kotlin.data.provider

import com.servicenow.exercise_kotlin.data.model.GameList
import io.reactivex.Observer

interface DataAccessor {

    fun getGamesList(callback: Observer<GameList>)

}