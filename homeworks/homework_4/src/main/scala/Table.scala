import scala.collection.mutable

class Table (val width: Int, val height: Int){
  var tableList = new mutable.MutableList[Cell]
  for (i <- 0 to width*height){
    tableList += new EmptyCell
  }

  def getCell(x: Int, y: Int): Option[Cell] ={
    if (0 > x || x >= width || 0 > y || y >= height)
      None
    else
      tableList.get(x + width*y)
  }

  def setCell(x: Int, y: Int, c: Cell) = {
    tableList.update(x + width*y, c)
  }
}