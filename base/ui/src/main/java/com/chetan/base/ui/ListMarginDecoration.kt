package umon.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * The item decorator for the recycler view with the [LinearLayoutManager], which will add margin between two
 * successive items in recycler view.
 */
class ListMarginDecoration(
    private val margin: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = 0
        outRect.right = 0
        outRect.bottom = 0
        outRect.top = if (parent.getChildAdapterPosition(view) == 0) 0 else this.margin
    }
}
