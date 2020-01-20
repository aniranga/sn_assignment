package com.servicenow.exercise_kotlin.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.servicenow.resources.Game

class GameList {

    @SerializedName("games")
    @Expose
    var games: List<Game>? = null

}
