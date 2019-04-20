import utest._
import Language._

package root {

  object OrTests extends TestSuite {
    val tests = Tests {
      'Or - {
        'ExprOrExprIsTrue - {
          assert(
            evaluate(
              OrOperation(
                AndOperation(
                  BooleanType(true),
                  BooleanType(true)
                ),
                OrOperation(
                  BooleanType(false),
                  BooleanType(false)
                )
              )
            ) == BooleanType(true)
          )
        }
        'ExprOrExprIsFalse - {
          assert(
            evaluate(
              OrOperation(
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
        'TrueOrBooleanIsTrue - {
          assert(
            evaluate(
              OrOperation(
                BooleanType(true),
                BooleanType(false)
              )
            ) == BooleanType(true)
          )

          assert(
            evaluate(
              OrOperation(
                BooleanType(false),
                BooleanType(true)
              )
            ) == BooleanType(true)
          )

          assert(
            evaluate(
              OrOperation(
                BooleanType(true),
                BooleanType(true)
              )
            ) == BooleanType(true)
          )

          assert(
            evaluate(
              OrOperation(
                BooleanType(false),
                BooleanType(false)
              )
            ) == BooleanType(false)
          )
        }
      }
    }
  }
}