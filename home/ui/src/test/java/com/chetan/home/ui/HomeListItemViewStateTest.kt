package com.chetan.home.ui

class HomeListItemViewStateTest {

//    @Test
//    fun shouldDecrementNoOfSupport_whenUnsupported() {
//        // GIVEN
//        val viewState = storyItemViewState(44, true)
//
//        // WHEN
//        viewState.supportedByMe = false
//
//        // THEN
//        assertThat(viewState.noOfSupports, equalTo(43))
//        assertThat(viewState.displayNoOfSupports, equalTo("43"))
//    }
//
//    @Test
//    fun shouldIncrementNoOfSupport_whenSupported() {
//        // GIVEN
//        val viewState = homeListItemViewState()
//
//        // WHEN
//        viewState.supportedByMe = true
//
//        // THEN
//        assertThat(viewState.noOfSupports, equalTo(44))
//        assertThat(viewState.displayNoOfSupports, equalTo("44"))
//    }

    private fun homeListItemViewState(supportedByMe: Boolean = true) = HomeListItemViewState(
        HomeListItem(
            title = "Beavers",
            description = "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            imageHref = "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
        ),
        palette = HomeColorPalette(0xfff, 0xfff)

    )
}
