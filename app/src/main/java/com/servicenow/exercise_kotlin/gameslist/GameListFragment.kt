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
import com.servicenow.exercise_kotlin.data.provider.DataAccessorProvider
import com.servicenow.exercise_kotlin.gameslist.GameDetailFragment.Companion.GAME_DESC_KEY
import com.servicenow.exercise_kotlin.gameslist.GameDetailFragment.Companion.GAME_TITLE_KEY
import com.servicenow.resources.Game
import kotlinx.android.synthetic.main.fragment_game_list.*
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
        presenter = GameListPresenterImpl(this, activity?.application as DataAccessorProvider)
        presenter?.fetchItems()
    }

    override fun onDestroy() {
        if (presenter != null) {
            presenter?.destroy()
        }
        super.onDestroy()
    }

    override fun onFetchedAllItems(resultList: List<Game>) {
        if (activity != null) {
            recyclerView?.visibility = View.VISIBLE
            recyclerView?.adapter = GameListAdapter(resultList,this, activity as Context)
        }
    }

    override fun showProgress() {
        progress_circular?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_circular?.visibility = View.GONE
    }

    override fun showError() {
        //TODO: show snackbar here
    }

    override fun onGameItemClicked(gameObj: Game) {
        var gameInfoBundle = Bundle()
        gameInfoBundle.putString(GAME_TITLE_KEY, gameObj.name)
        gameInfoBundle.putString(GAME_DESC_KEY, gameObj.longDescription)
        navController?.navigate(R.id.action_gameListFragment_to_gameDetailFragment, gameInfoBundle)
    }

    inner class SpacesItemDecoration(private val mSpace: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = mSpace;
        }
    }

}