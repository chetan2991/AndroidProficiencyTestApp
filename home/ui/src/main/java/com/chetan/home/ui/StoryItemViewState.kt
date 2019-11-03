//package umon.story.ui
//
//import androidx.databinding.BaseObservable
//import androidx.databinding.Bindable
//import umon.story.domain.model.Story
//import umon.ui.binding.bind
//
//data class StoryItemViewState(
//    val story: Story,
//    val palette: StoryColorPalette
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
