import utest._
import Language._

package root {

  object XorTests extends TestSuite {
    val tests = Tests {
      'Xor {
        'TrueXorTrue {
          assert(
            evaluate(
              XorOperation(BooleanType(true), BooleanType(true))
            ) == BooleanType(false)
          )
        }
        'FalseXorFalse {
          assert(
            evaluate(
              XorOperation(BooleanType(false), BooleanType(false))
            ) == BooleanType(false)
          )
        }
        'TrueXorFalse {
          assert(
            evaluate(
              XorOperation(BooleanType(true), BooleanType(false))
            ) == BooleanType(true)
          )
        }
        'FalseXorTrue {
          assert(
            evaluate(
              XorOperation(BooleanType(false), BooleanType(true))
            ) == BooleanType(true)
          )
        }
        'ExprXorExprIsTrue {
          assert(
            evaluate(
              XorOperation(
                AndOperation(
                  BooleanType(true),
                  BooleanType(false)
                ),
                OrOperation(
                  BooleanType(true),
                  BooleanType(false)
                )
              )
            ) == BooleanType(true)
          )
        }
        'ExprXorExprIsFalse {
          assert(
            evaluate(
              XorOperation(
                OrOperation(
                  BooleanType(false),
                  BooleanType(false)
                ),
                AndOperation(
                  BooleanType(true),
                  BooleanType(false)
                )
              )
            ) == BooleanType(false)
          )
        }
      }
    }
  }
}