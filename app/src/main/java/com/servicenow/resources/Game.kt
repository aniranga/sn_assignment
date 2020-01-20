package com.servicenow.resources

import com.servicenow.exercise.R

class Game(
    var name: String,
    var cover: String,
    var shortDescription: String,
    var longDescription: String
) {

    override fun toString(): String {
        return name
    }

    companion object {
        fun getIconResource(cover: String): Int {
            when (cover) {
                "Castlevania" -> return R.drawable.castlevania
                "Contra" -> return R.drawable.contra
                "DoubleDragon2" -> return R.drawable.doubledragon2
                "DuckHunt" -> return R.drawable.duckhunt
                "Jackal" -> return R.drawable.jackal
                "Kirby" -> return R.drawable.kirby
                "KungFu" -> return R.drawable.kungfu
                "LodeRunner" -> return R.drawable.loderunner
                "MarioBros" -> return R.drawable.mariobros
                "MarioBros2" -> return R.drawable.mariobros2
                "Megaman" -> return R.drawable.megaman
                "Megaman2" -> return R.drawable.megaman2
                "SuperTecmoBowl" -> return R.drawable.supertecmobowl
                "Metroid" -> return R.drawable.metroid
                "Tetris" -> return R.drawable.tetris
            }
            return -1
        }
    }
}