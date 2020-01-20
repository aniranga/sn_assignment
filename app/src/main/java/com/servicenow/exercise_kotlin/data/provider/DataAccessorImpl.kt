package com.servicenow.exercise_kotlin.data.provider

import android.app.Application
import com.servicenow.exercise.BuildConfig
import com.servicenow.exercise_kotlin.data.model.GameList
import com.servicenow.resources.Game
import com.servicenow.resources.NESGames
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

class DataAccessorImpl(val app: Application) : DataAccessor {

    val SERVER_URL = "https://jsonblob.com/api/jsonBlob/f5bf443c-160d-11ea-ab7b-c5ee597d34d8/"
    private var apiService: ApiService? = null

    init {
        apiService = createApiService()
    }

    override fun getGamesList(callback: Observer<GameList>) {
        apiService?.getGamesListData(SERVER_URL)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(callback)
    }

    private fun createApiService(): ApiService {

        val httpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpBuilder.addInterceptor(loggingInterceptor)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpBuilder.build())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    /**
     * retrofit interface
     */
    private interface ApiService {

        @GET
        fun getGamesListData(@Url url: String): Observable<GameList>
    }
}