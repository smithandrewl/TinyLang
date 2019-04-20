import utest._
import Language._

package root {
  object ListTests extends TestSuite {
    val tests = Tests {
      'ListTests {
        'AppendTests {
          'AppendOneToEmptyList {
            assert(
              evaluate(
                AppendOperation(IntegerType(1), EmptyList())
              ) == ListType(IntegerType(1), EmptyList())
            )
          }
          'AppendTwoToListOfOne {
            assert(
              evaluate(
                AppendOperation(IntegerType(2), ListType(IntegerType(1), EmptyList()))
              ) == ListType(IntegerType(2), ListType(IntegerType(1), EmptyList()))
            )
          }

          'AppendTrueToListOfOne {
            assert(
              evaluate(
                AppendOperation(BooleanType(true), ListType(IntegerType(1), EmptyList()))
              ) == ListType(BooleanType(true), ListType(IntegerType(1), EmptyList()))
            )
          }
        }
      }
    }
  }
}

