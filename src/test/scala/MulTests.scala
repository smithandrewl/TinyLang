import utest._
import Language._

package root {
  object MulTests extends TestSuite {
    val tests = Tests {
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
  }
}
