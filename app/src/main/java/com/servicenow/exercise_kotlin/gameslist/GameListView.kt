package com.servicenow.exercise_kotlin.gameslist

import com.servicenow.resources.Game

interface GameListView {

    fun onFetchedAllItems(resultList: List<Game>)

    fun showProgress()

    fun hideProgress()

    fun showError()

}