//Primary constructor parameters with val and var
class Point (var x: Int, var y: Int) {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String =
    s"($x, $y)"
}


//Parameters without val or var are private values, visible only within the class.
class Point(x: Int, y: Int)