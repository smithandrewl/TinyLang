import utest._
import Language._

package root {
  object AndTests extends TestSuite {
    val tests = Tests {
      'And - {
        'ExprAndExprIsTrue - {
          assert(
            evaluate(
              AndOperation(
                AndOperation(
                  BooleanType(true),
                  BooleanType(true)
                ),
                BooleanType(true)
              )
            )
              == BooleanType(true))
        }
        'ExprAndExprIsFalse - {
          assert(
            evaluate(
              AndOperation(
                BooleanType(true),
                AndOperation(BooleanType(false), BooleanType(true))
              )
            ) == BooleanType(false)
          )
        }
        'FalseAndBooleanIsFalse - {
          assert(
            evaluate(
              AndOperation(
                BooleanType(false),
                BooleanType(false)
              )
            ) == BooleanType(false)
          )

          assert(
            evaluate(
              AndOperation(
                BooleanType(false),
                BooleanType(true)
              )
            ) == BooleanType(false)
          )
        }
        'BooleanAndFalseIsFalse - {
          assert(
            evaluate(
              AndOperation(
                BooleanType(false),
                BooleanType(false)
              )
            ) == BooleanType(false)
          )

          assert(
            evaluate(
              AndOperation(
                BooleanType(true),
                BooleanType(false)
              )
            ) == BooleanType(false)
          )
        }
        'TrueAndTrueIsTrue - {
          assert(
            evaluate(
              AndOperation(
                BooleanType(true),
                BooleanType(true)
              )
            ) == BooleanType(true)
          )
        }
      }
    }
  }
}