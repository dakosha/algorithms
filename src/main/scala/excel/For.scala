package excel

/**
  * @author Dauren Mussa
  * @since 3/13/17
  */
object Loops {

  def While(condition: Boolean)(body: Unit): Unit = {
    if (condition) {
      body
      While(condition)(body)
    }
  }

  def main(args: Array[String]): Unit = {
    var index = 0
    While(index < 10) {
      println(index)
      index += 1
    }
  }

}
