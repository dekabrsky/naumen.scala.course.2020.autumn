import scala.collection.mutable

class ReferenceCell (val ix: Int, val iy: Int, val table: Table) extends Cell{

  override def toString = {
    if (0 > ix || ix >= table.width || 0 > iy || iy >= table.height)
      "outOfRange"
    table.getCell(ix, iy) match {
      case None => ""
      case Some(c: ReferenceCell) => passage(ix, iy, table)
      case Some(c: Cell) => c.toString
    }
  }

  def passage(ix: Int, iy: Int, table: Table): String ={
    var ml = new mutable.MutableList[Int]
    ml += ix + iy*table.width
    var cell = table.getCell(ix, iy)
    while (true){
      cell match {
        case None => return ""
          case Some(c:ReferenceCell) =>
          val x = c.ix
          val y = c.iy
          cell = table.getCell(x, y)
          val xy = x + y*table.width
          if (ml.contains(xy))
            return "cyclic"
          else
            ml += x + y*table.width
        case Some(c:Cell) => c.toString
      }
    }
    cell.toString
  }
}
