object Language {
  sealed abstract class Expr
  case class BooleanType(value: Boolean)                           extends Expr
  case class AndOperation(left: Expr,  right: Expr)                extends Expr
  case class OrOperation(left:  Expr,  right: Expr)                extends Expr
  case class NotOperation(center: BooleanType)                     extends Expr
  case class XorOperation(left: BooleanType, right: BooleanType)   extends Expr

  def evaluate(expr: Expr): Expr = expr match {
    case BooleanType(x) => BooleanType(x)
    case AndOperation(BooleanType(false), BooleanType(_))     => BooleanType(false)
    case AndOperation(BooleanType(_),     BooleanType(false)) => BooleanType(false)
    case AndOperation(BooleanType(_),     BooleanType(_))     => BooleanType(true)
    case AndOperation(x, y)                                   => evaluate(AndOperation(evaluate(x), evaluate(y)))

    case OrOperation(BooleanType(true),   BooleanType(_))     => BooleanType(true)
    case OrOperation(BooleanType(_),      BooleanType(true))  => BooleanType(true)
    case OrOperation(BooleanType(_),      BooleanType(_))     => BooleanType(false)
    case OrOperation(left, right) => evaluate(OrOperation(evaluate(left), evaluate(right)))

    case NotOperation(BooleanType(true))                      => BooleanType(false)
    case NotOperation(BooleanType(false))                     => BooleanType(true)

    case XorOperation(BooleanType(true),  BooleanType(false)) => BooleanType(true)
    case XorOperation(BooleanType(false), BooleanType(true))  => BooleanType(true)
    case XorOperation(BooleanType(true),  BooleanType(true))  => BooleanType(false)
    case XorOperation(BooleanType(false), BooleanType(false)) => BooleanType(false)
  }
}
