package com.chetan.home.domain

import javax.inject.Inject
interface  GetFacts {
    fun  getFacts(): LiveDataHomeResult
}
class GetFactsImpl @Inject constructor(
    private val homeRepository : HomeRepository
) : GetFacts {
    override fun getFacts(): LiveDataHomeResult {
        return homeRepository.getFacts()
    }
}
