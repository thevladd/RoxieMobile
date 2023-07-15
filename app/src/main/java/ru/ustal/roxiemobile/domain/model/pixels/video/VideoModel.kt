package ru.ustal.roxiemobile.domain.model.pixels.video

data class VideoModel(
    val avg_color: Any? = null,
    val duration: Int? = null,
    val full_res: Any? = null,
    val height: Int? = null,
    val id: Int? = null,
    val image: String? = null,
    val tags: List<Any?>? = null,
    val url: String? = null,
    val userModel: UserModel? = null,
    val video_files: List<VideoFileModel?>? = null,
    val video_pictures: List<VideoPictureModel?>? = null,
    val width: Int? = null
)