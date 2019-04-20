import utest._
import Language._

package root {

  object AddTests extends TestSuite {
    val tests = Tests {
      'AddOperationTests {
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
    }
  }
}
