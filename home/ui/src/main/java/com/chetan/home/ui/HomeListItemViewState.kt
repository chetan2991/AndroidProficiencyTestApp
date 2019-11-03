package com.chetan.home.ui

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.chetan.home.domain.model.HomeListItem

class HomeListItemViewState(
    val homeListItem : HomeListItem,
    val palette: HomeColorPalette
) : BaseObservable()


//data class StoryItemViewState(
//    val homeListItem: HomeListItem,
//    val palette: HomeColorPalette
//) : BaseObservable() {
//
//    @get:Bindable
//    var supportedByMe: Boolean by bind(BR.supportedByMe, story.supportedByMe) { _, new ->
//        noOfSupports += if (new) 1 else -1
//    }
//
//    var noOfSupports: Int by bind(BR.displayNoOfSupports, story.noOfSupports)
//    @get:Bindable
//    val displayNoOfSupports
//        get() = noOfSupports.toString()
//
//    val noOfComments: Int by bind(BR.displayNoOfComments, story.noOfComments)
//    @get:Bindable
//    val displayNoOfComments
//        get() = noOfComments.toString()
//}