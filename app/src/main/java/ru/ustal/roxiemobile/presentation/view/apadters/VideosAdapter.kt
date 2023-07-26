package ru.ustal.roxiemobile.presentation.view.apadters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.exoplayer2.SimpleExoPlayer
import ru.ustal.roxiemobile.databinding.ItemVideoBinding
import ru.ustal.roxiemobile.domain.model.pixels.video.VideoModel
import ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter.KDelegateAdapter
import ru.ustal.roxiemobile.utils.prepareExoPlayerMediaSource

class VideosAdapter :
    KDelegateAdapter<VideoModel, ItemVideoBinding>(ItemVideoBinding::inflate) {

    override fun ItemVideoBinding.onBind(item: VideoModel) {
        video = item
    }

    override fun isForViewType(item: Any): Boolean = item is VideoModel

    override fun VideoModel.getItemId(): Any = this.hashCode()

    override fun ItemVideoBinding.onRecycled() {
    }

    override fun ItemVideoBinding.onAttachedToWindow(
        holder: ViewBindingHolder<ItemVideoBinding>,
        content: VideoModel
    ) {
        (holder as VideoViewBindingHolder).exoPlayer
            .prepareExoPlayerMediaSource(
                "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4"
                //content.video_files?.last()?.link ?: ""
                , videoView.context
            ).play()
    }

    override fun ItemVideoBinding.onDetachedFromWindow(holder: ViewBindingHolder<ItemVideoBinding>) {
        (holder as VideoViewBindingHolder).exoPlayer
            .pause()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = viewBindingInflater.invoke(layoutInflater, parent, false)
        viewBinding.onCreated()
        val exoPlayer = SimpleExoPlayer.Builder(parent.context).build()
        viewBinding.videoView.player = exoPlayer
        return VideoViewBindingHolder(
            exoPlayer,
            viewBinding
        )
    }

    class VideoViewBindingHolder<V : ViewBinding>(
        val exoPlayer: SimpleExoPlayer,
        viewBinding: V
    ) : ViewBindingHolder<V>(viewBinding)

}