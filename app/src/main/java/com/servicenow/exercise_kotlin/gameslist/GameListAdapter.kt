package com.servicenow.exercise_kotlin.gameslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.servicenow.exercise.R
import com.servicenow.resources.Game
import kotlinx.android.synthetic.main.game_list_item.view.*

class GameListAdapter(val items : List<Game>, private val clickCallback: ClickCallback, private val context: Context) : RecyclerView.Adapter<GameListAdapter.GameItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_list_item, parent, false)
        return GameItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GameItemViewHolder, position: Int) {
        holder.bindDataToView(items[position], clickCallback)
    }

    inner class GameItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindDataToView(gameObj: Game, clickCallback: ClickCallback) {
            itemView.image.setImageResource(Game.getIconResource(gameObj.cover))
            itemView.text1.text = gameObj.name
            itemView.text2.text = gameObj.shortDescription
        }

    }

    interface ClickCallback {

    }

}