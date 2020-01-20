package com.servicenow.exercise_java;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.servicenow.resources.Game;
import com.servicenow.resources.NESGames;
import com.servicenow.exercise.R;

public class MainActivity extends ListActivity {

    public static final Game[] nesGames = NESGames.INSTANCE.getList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new GameAdapter());
    }

    class GameAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return nesGames.length;
        }

        @Override
        public Object getItem(int position) {
            return nesGames[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                row = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item, parent, false);
            }

            ImageView gameCover = row.findViewById(R.id.image);
            TextView gameName = row.findViewById(R.id.text1);
            TextView gameDescription = row.findViewById(R.id.text2);

            Game game = nesGames[position];
            gameName.setText(game.getName());
            gameDescription.setText(game.getShortDescription());
            gameCover.setImageResource(Game.Companion.getIconResource(game.getCover()));

            return row;
        }
    }
}
