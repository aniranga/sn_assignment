package com.servicenow.exercise_kotlin.data.provider

interface DataAccessorProvider {

    fun getDataAccessor() : DataAccessor
}