package com.chetan.home.domain

interface HomeRepository {
    fun getFacts(): LiveDataHomeResult
}
