package com.servicenow.exercise_kotlin.gameslist

import com.servicenow.exercise_kotlin.data.provider.DataAccessor
import com.servicenow.exercise_kotlin.data.provider.DataAccessorProvider
import com.servicenow.resources.Game
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class GameListPresenterImpl(val gameListView: GameListView, dataAccessorProvider: DataAccessorProvider): GameListPresenter {

    private val dataAccessor: DataAccessor = dataAccessorProvider.getDataAccessor()
    private var resultList : ArrayList<Game> = ArrayList()
    private var disposables: CompositeDisposable = CompositeDisposable()

    override fun fetchItems() {
        gameListView.showProgress()
        dataAccessor.getGamesList(GamesListSubscriber())
    }

    override fun destroy() {
        disposables.clear()
    }

    private inner class GamesListSubscriber : Observer<ArrayList<Game>> {
        override fun onComplete() {

        }

        override fun onSubscribe(d: Disposable) {
            disposables.add(d)
        }

        override fun onNext(list: ArrayList<Game>) {
            gameListView.hideProgress()
            resultList = list
            gameListView.onFetchedAllItems(resultList)
        }

        override fun onError(e: Throwable) {
            gameListView.hideProgress()
            gameListView.showError()
        }

    }
}