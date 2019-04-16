object Language {
  sealed abstract class Expr
  case class BooleanType(value: Boolean)            extends Expr
  case class AndOperation(left: Expr,  right: Expr) extends Expr
  case class OrOperation(left:  Expr,  right: Expr) extends Expr
  case class XorOperation(left: Expr,  right: Expr) extends Expr
  case class NotOperation(center: Expr)             extends Expr

  case class IntegerType(value: Int)                extends Expr
  case class AddOperation(left: Expr, right: Expr)  extends Expr

  def evaluate(expr: Expr): Expr = {
    expr match {
      case BooleanType(x)            => BooleanType(x)
      case IntegerType(x)            => IntegerType(x)
      case AndOperation(left, right) => evalAnd(AndOperation(left, right))
      case OrOperation(left, right)  => evalOr(OrOperation(left, right))
      case NotOperation(center)      => evalNot(NotOperation(center))
      case XorOperation(left, right) => evalXor(XorOperation(left, right))
      case AddOperation(left, right) => evalAdd(AddOperation(left, right))
    }
  }

  def evalAdd(expr: AddOperation): Expr = (evaluate(expr.left), evaluate(expr.right)) match {
    case (IntegerType(left), IntegerType(right)) => {
      print(s"left=${left}, right=${right}")
      IntegerType(left + right)
    }
    case (_, _) => throw new Exception("Add called with non integer operands")
  }

  def evalAnd(expr: AndOperation): Expr = expr match  {
    case AndOperation(BooleanType(false), BooleanType(_))     => BooleanType(false)
    case AndOperation(BooleanType(_),     BooleanType(false)) => BooleanType(false)
    case AndOperation(BooleanType(_),     BooleanType(_))     => BooleanType(true)
    case AndOperation(x, y)                                   => evaluate(AndOperation(evaluate(x), evaluate(y)))
  }

  def evalOr(expr: OrOperation): Expr = expr match {
    case OrOperation(BooleanType(true),   BooleanType(_))     => BooleanType(true)
    case OrOperation(BooleanType(_),      BooleanType(true))  => BooleanType(true)
    case OrOperation(BooleanType(_),      BooleanType(_))     => BooleanType(false)
    case OrOperation(left, right)                             => evaluate(OrOperation(evaluate(left), evaluate(right)))
  }

  def evalNot(expr: NotOperation): Expr = expr match {
    case NotOperation(BooleanType(true))  => BooleanType(false)
    case NotOperation(BooleanType(false)) => BooleanType(true)
    case NotOperation(center)             => evaluate(NotOperation(evaluate(center)))
  }

  def evalXor(expr: XorOperation): Expr = expr match {
    case XorOperation(BooleanType(true),  BooleanType(false)) => BooleanType(true)
    case XorOperation(BooleanType(false), BooleanType(true))  => BooleanType(true)
    case XorOperation(BooleanType(true),  BooleanType(true))  => BooleanType(false)
    case XorOperation(BooleanType(false), BooleanType(false)) => BooleanType(false)
    case XorOperation(left, right)                            => evaluate(XorOperation(evaluate(left), evaluate(right)))
  }
}
