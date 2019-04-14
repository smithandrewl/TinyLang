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
      'Xor{
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
      }
    }
  }
}
