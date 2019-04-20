import utest._
import Language._

package root {

  object SubtractionTests extends TestSuite {
    val tests = Tests {
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
    }
  }
}
