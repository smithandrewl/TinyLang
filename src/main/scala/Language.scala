object Language {
  sealed abstract class Expr
  case class BooleanType(value: Boolean)            extends Expr
  case class AndOperation(left: Expr,  right: Expr) extends Expr
  case class OrOperation(left:  Expr,  right: Expr) extends Expr
  case class XorOperation(left: Expr,  right: Expr) extends Expr
  case class NotOperation(center: Expr)             extends Expr

  case class IntegerType(value: Int)                extends Expr
  case class AddOperation(left: Expr, right: Expr)  extends Expr
  case class SubOperation(left: Expr, right: Expr)  extends Expr
  case class MulOperation(left: Expr, right: Expr)  extends Expr

  case class Equals(left: Expr, right: Expr) extends Expr
  case class IfOperation(condition:Expr, trueExpr: Expr, falseExpr: Expr) extends Expr

  def evaluate(expr: Expr): Expr = {
    expr match {
      case BooleanType(x)            => BooleanType(x)
      case IntegerType(x)            => IntegerType(x)
      case AndOperation(left, right) => evalAnd(AndOperation(left, right))
      case OrOperation(left, right)  => evalOr(OrOperation(left, right))
      case NotOperation(center)      => evalNot(NotOperation(center))
      case XorOperation(left, right) => evalXor(XorOperation(left, right))
      case AddOperation(left, right) => evalAdd(AddOperation(left, right))
      case SubOperation(left, right) => evalSub(SubOperation(left, right))
      case MulOperation(left, right) => evalMul(MulOperation(left, right))
      case Equals(left, right) => evalEquals(Equals(left, right))
      case IfOperation(condition, trueExpr, falseExpr) => evalIf(IfOperation(condition, trueExpr, falseExpr))
    }
  }

  def evalIf(expr: IfOperation): Expr = evaluate(expr.condition) match {
    case BooleanType(value) => if(value) evaluate(expr.trueExpr) else evaluate(expr.falseExpr)
    case _ => throw new Exception("Boolean value expected in if condition")
  }
  def evalEquals(expr: Language.Equals): Expr = (evaluate(expr.left), evaluate(expr.right)) match {
    case (IntegerType(left), IntegerType(right)) => BooleanType(left == right)
    case (BooleanType(left), BooleanType(right)) => BooleanType(left == right)
    case (_, _) => throw new Exception("Cannot compare operands of different types")
  }
  def evalMul(expr: MulOperation): Expr = (evaluate(expr.left), evaluate(expr.right)) match {
    case (IntegerType(left), IntegerType(right)) => IntegerType(left * right)
    case (_, _) => throw new Exception("Mul called with non integer operands")
  }
  def evalSub(expr: SubOperation): Expr = (evaluate(expr.left), evaluate(expr.right)) match {
    case (IntegerType(left), IntegerType(right)) => {
      IntegerType(left - right)
    }
    case (_, _) => throw new Exception("Sub called with non integer operands")
  }
  def evalAdd(expr: AddOperation): Expr = (evaluate(expr.left), evaluate(expr.right)) match {
    case (IntegerType(left), IntegerType(right)) => {
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
