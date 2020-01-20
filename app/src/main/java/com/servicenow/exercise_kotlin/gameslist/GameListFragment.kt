package com.servicenow.exercise_kotlin.gameslist

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.servicenow.exercise.R
import com.servicenow.resources.Game
import kotlinx.android.synthetic.main.fragment_game_list.view.*

class GameListFragment: Fragment(), GameListView, GameListAdapter.ClickCallback {

    private var presenter: GameListPresenter?= null
    private var navController : NavController?= null
    private var snackBar: Snackbar?= null
    private var recyclerView: RecyclerView?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        recyclerView = view.recycler_list
        recyclerView?.layoutManager = LinearLayoutManager(view.context)
        val spacing = getResources().getDimensionPixelSize(R.dimen.recycler_item_spacing)
        val spaceDecoration = SpacesItemDecoration(spacing)
        recyclerView?.addItemDecoration(spaceDecoration)
        presenter = GameListPresenterImpl(this)
        presenter?.fetchItems()
    }

    override fun onFetchedAllItems(resultList: List<Game>) {
        if (activity != null) {
            recyclerView?.visibility = View.VISIBLE
            recyclerView?.adapter = GameListAdapter(resultList,this, activity as Context)
        }
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showError() {

    }

    inner class SpacesItemDecoration(private val mSpace: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = mSpace;
        }
    }

}