object Language {
  sealed abstract class Expr
  case class BooleanType(value: Boolean)                           extends Expr
  case class AndOperation(left: BooleanType,  right: BooleanType)  extends Expr
  case class OrOperation(left:  BooleanType,  right: BooleanType)  extends Expr
  case class NotOperation(center: BooleanType)                     extends Expr
  case class XorOperation(left: BooleanType, right: BooleanType)   extends Expr

  def evaluate(expr: Expr) = expr match {
    case BooleanType(x) => BooleanType(x)
    case AndOperation(BooleanType(false), BooleanType(_))     => BooleanType(false)
    case AndOperation(BooleanType(_),     BooleanType(false)) => BooleanType(false)
    case AndOperation(BooleanType(_),     BooleanType(_))     => BooleanType(true)
    case OrOperation(BooleanType(true),   BooleanType(_))     => BooleanType(true)
    case OrOperation(BooleanType(_),      BooleanType(true))  => BooleanType(true)
    case OrOperation(BooleanType(_),      BooleanType(_))     => BooleanType(false)
    case NotOperation(BooleanType(true))                      => BooleanType(false)
    case NotOperation(BooleanType(false))                     => BooleanType(true)
    case XorOperation(BooleanType(true),  BooleanType(false)) => BooleanType(true)
    case XorOperation(BooleanType(false), BooleanType(true))  => BooleanType(true)
    case XorOperation(BooleanType(true),  BooleanType(true))  => BooleanType(false)
    case XorOperation(BooleanType(false), BooleanType(false)) => BooleanType(false)
  }
}
