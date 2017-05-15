package excel

/**
  * @author Dauren Mussa
  * @since 2/21/17
  */
trait Expression {
  def eval : Any
}

case class ValueExpression(var value: Int) extends Expression {
  def eval = value
}

case class ReferenceExpression(val map: Map[String, Expression], var value: String) extends Expression {
  def eval = map(value).eval
}
