import utest._
import Language._

package root {

  object NotTests extends TestSuite {
    val tests = Tests {
      'Not {
        'NotTrueIsFalse {
          assert(
            evaluate(
              NotOperation(BooleanType(true))
            ) == BooleanType(false)
          )
        }
        'NotFalseIsTrue {
          assert(
            evaluate(
              NotOperation(BooleanType(false))
            ) == BooleanType(true)
          )
        }
        'NotExprIsTrue {
          assert(
            evaluate(
              NotOperation(AndOperation(BooleanType(true), BooleanType(false)))
            ) == BooleanType(true)
          )
        }
        'NotExprIsFalse {
          assert(
            evaluate(
              NotOperation(
                AndOperation(
                  BooleanType(true),
                  BooleanType(true)
                )
              )
            ) == BooleanType(false)
          )
        }
      }
    }
  }
}