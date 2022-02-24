class PostComment(dataSource: MutableMap<String, Any>) {
    val title: String by dataSource
    var likes: Int by dataSource
    val comment: String by PoliteStringVariant(dataSource)

    override fun toString() = "title: $title, likes: $likes, comment: $comment"
}