package com.servicenow.exercise_kotlin.data.provider

import com.servicenow.resources.Game
import io.reactivex.Observer

interface DataAccessor {

    fun getGamesList(callback: Observer<ArrayList<Game>>)

}