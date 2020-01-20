package com.servicenow.exercise_kotlin.gameslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.servicenow.exercise.R
import kotlinx.android.synthetic.main.fragment_game_detail.*

class GameDetailFragment : Fragment() {

    companion object {
        val GAME_TITLE_KEY = "GAME_TITLE"
        val GAME_DESC_KEY = "GAME_LONG_DESC"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var title = arguments?.getString(GAME_TITLE_KEY) // get title & desc from bundle
        var desc = arguments?.getString(GAME_DESC_KEY)
        game_title.text = title
        long_desc.text = desc
    }
}