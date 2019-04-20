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

        'SubOperationTests {
          'TwoMinusTwoIsZero {
            assert(
              evaluate(
                SubOperation(
                  IntegerType(2),
                  IntegerType(2)
                )
              ) == IntegerType(0)
            )
          }
          'ZeroMinusTwoIsNegTwo {
            assert(
              evaluate(
                SubOperation(
                  IntegerType(0),
                  IntegerType(2)
                )
              ) == IntegerType(-2)
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
