package com.servicenow.exercise_kotlin

import android.app.ListActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.servicenow.resources.Game
import com.servicenow.resources.NESGames
import com.servicenow.exercise.R

class MainActivityKt : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = GameAdapter()
    }

    inner class GameAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return NESGames.list.size
        }

        override fun getItem(position: Int): Any {
            return NESGames.list[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            val row: View = convertView ?: LayoutInflater.from(this@MainActivityKt).inflate(
                R.layout.game_list_item,
                parent,
                false
            )

            val gameCover: ImageView = row.findViewById(R.id.image) as ImageView
            val gameName = row.findViewById(R.id.text1) as TextView
            val gameDescription = row.findViewById(R.id.text2) as TextView

            val game: Game = NESGames.list[position]
            gameName.text = game.name
            gameDescription.text = game.shortDescription
            gameCover.setImageResource(Game.getIconResource(game.cover))
            return row
        }
    }
}
