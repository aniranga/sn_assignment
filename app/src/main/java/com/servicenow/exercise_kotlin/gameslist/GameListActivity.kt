package com.servicenow.exercise_kotlin.gameslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.servicenow.exercise.R

class GameListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_list);
    }
}