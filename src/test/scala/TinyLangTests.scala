import utest._
import Language._

package root {

  object TinyLangTests extends TestSuite {
    val tests = Tests {
      'Boolean - {
        'TrueIsTrue - {
          evaluate(BooleanType(true)) == BooleanType(true)
        }

        'FalseIsFalse - {
          assert(evaluate(BooleanType(false)) == BooleanType(false))
        }
      }
      'And - {
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

      'Or - {
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
      }
    }
  }
}
