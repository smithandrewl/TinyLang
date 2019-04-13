object Language {
  sealed abstract class Type
  case class BooleanType(value: Boolean) extends Type

  def evaluate(expr: Type) = expr match {
    case BooleanType(x) => BooleanType(x)
  }
}
