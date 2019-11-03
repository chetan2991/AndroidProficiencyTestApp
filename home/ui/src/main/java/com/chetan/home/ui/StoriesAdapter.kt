//package umon.story.ui
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import umon.story.ui.StoryItemBinding.inflate
//import umon.ui.binding.BindableAdapter
//import umon.ui.diffCallback
//
//class StoriesAdapter(
//    private val viewModel: StoryListViewModel
//) : RecyclerView.Adapter<StoriesAdapter.ViewHolder>(), BindableAdapter<StoryItemViewState> {
//
//    override var items: List<StoryItemViewState> by diffCallback(emptyList()) { o, n ->
//        o.story.id == n.story.id
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(parent)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(items[position], viewModel)
//    }
//
//    class ViewHolder(
//        private val binding: StoryItemBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//
//        companion object {
//            operator fun invoke(parent: ViewGroup): ViewHolder {
//                val binding = inflate(LayoutInflater.from(parent.context), parent, false)
//                return ViewHolder(binding)
//            }
//        }
//
//        fun bind(viewState: StoryItemViewState, viewModel: StoryListViewModel) {
//            binding.viewState = viewState
//            binding.viewModel = viewModel
//            binding.executePendingBindings()
//        }
//    }
//}
