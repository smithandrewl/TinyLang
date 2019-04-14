object Language {
  sealed abstract class Expr
  case class BooleanType(value: Boolean) extends Expr
  def evaluate(expr: Expr) = expr match {
    case BooleanType(x) => BooleanType(x)
  }
}
