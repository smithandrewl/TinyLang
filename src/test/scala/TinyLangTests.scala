import utest._
import Language._

package root {

  object TinyLangTests extends TestSuite {
    val tests = Tests {
      'Boolean - {
        'TrueIsTrue - {
          assert(evaluate(BooleanType(true)) == BooleanType(true))
        }

        'FalseIsFalse - {
          assert(evaluate(BooleanType(false)) == BooleanType(false))
        }

      }
      'IntegerTests {
        'AddOperationTests{
          'TwoPlusTwoIsFour {
            assert(
              evaluate(
                AddOperation(
                  IntegerType(2),
                  IntegerType(2)
                )
              ) == IntegerType(4)
            )
          }
        }

        'MulOperationTests {
          'TwoTimesFourIsEight {
            assert(
              evaluate(
                MulOperation(
                  IntegerType(2),
                  IntegerType(4)
                )
              ) == IntegerType(8)
            )
          }
        }
        'IfTests{
          'TrueThenOne {
            assert(
              evaluate(
                IfOperation(
                  AndOperation(
                    BooleanType(true),
                    BooleanType(true)
                  ),
                  AddOperation(
                    IntegerType(0),
                    IntegerType(1)
                  ),
                  BooleanType(false)
                )) == IntegerType(1)
            )
          }
          'FalseThenFalse {
            assert(
              evaluate(
                IfOperation(
                  AndOperation(
                    BooleanType(false),
                    BooleanType(true)
                  ),
                  AddOperation(
                    IntegerType(0),
                    IntegerType(1)
                  ),
                  BooleanType(false)
                )) == BooleanType(false)
            )
          }
        }
      }
    }
  }
}
