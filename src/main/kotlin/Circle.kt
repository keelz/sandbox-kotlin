data class Circle(val cx: Int, val cy: Int, val r: Int)

infix operator fun Circle.contains(p: Point):Boolean = (p.x - cx) * (p.x - cx) + (p.y - cy) * (p.y - cy) < r * r
