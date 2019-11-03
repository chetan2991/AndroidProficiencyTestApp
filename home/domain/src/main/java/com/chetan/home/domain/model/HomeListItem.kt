package com.chetan.home.domain.model

data class HomeListItem(
    val title: String,
    val description: String,
    val imageHref : String
) : java.io.Serializable{
    companion object{
        val EMPTY = HomeListItem(
            title = "",
            description = "",
            imageHref =  ""
        )
    }
}