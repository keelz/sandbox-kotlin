class TvRemote(val tv: TV) : Remote {
    override fun down() { tv.volume-- }
    override fun up() { tv.volume++ }
}