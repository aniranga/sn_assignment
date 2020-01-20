package com.servicenow.exercise_kotlin

import android.app.Application
import com.servicenow.exercise_kotlin.data.provider.DataAccessor
import com.servicenow.exercise_kotlin.data.provider.DataAccessorImpl
import com.servicenow.exercise_kotlin.data.provider.DataAccessorProvider

class GameListApp: Application(), DataAccessorProvider {

    private var dataAccessor: DataAccessor?= null

    override fun getDataAccessor(): DataAccessor {
        if (dataAccessor == null) {
            dataAccessor = DataAccessorImpl(this)
        }
        return dataAccessor!!
    }
}