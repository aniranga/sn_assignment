package com.servicenow.exercise_kotlin.gameslist

import android.util.Log
import com.servicenow.exercise_kotlin.data.model.GameList
import com.servicenow.exercise_kotlin.data.provider.DataAccessor
import com.servicenow.exercise_kotlin.data.provider.DataAccessorProvider
import com.servicenow.resources.Game
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class GameListPresenterImpl(val gameListView: GameListView, dataAccessorProvider: DataAccessorProvider): GameListPresenter {

    private val dataAccessor: DataAccessor = dataAccessorProvider.getDataAccessor()
    private var resultList : List<Game> = ArrayList()
    private var disposables: CompositeDisposable = CompositeDisposable()

    override fun fetchItems() {
        gameListView.showProgress()
        dataAccessor.getGamesList(GamesListSubscriber())
    }

    override fun destroy() {
        disposables.clear()
    }

    private inner class GamesListSubscriber : Observer<GameList> {
        override fun onComplete() {

        }

        override fun onSubscribe(d: Disposable) {
            disposables.add(d)
        }

        override fun onNext(listHolder: GameList) {
            Log.e("GamesListPresenterImpl", "got reults: " + listHolder.games?.size)
            gameListView.hideProgress()
            resultList = listHolder?.games!!
            gameListView.onFetchedAllItems(resultList)
        }

        override fun onError(e: Throwable) {
            gameListView.hideProgress()
            gameListView.showError()
        }

    }
}