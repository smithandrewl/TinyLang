import utest._
import Language._

package root {

  object IfTests extends TestSuite {
    val tests = Tests {
      'IfTests {
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
