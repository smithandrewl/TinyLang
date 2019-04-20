import utest._
import Language._

package root {

  object IdentityTests extends TestSuite {
    val tests = Tests {
      'IdentityTests - {
        'TrueIsTrue - {
          assert(evaluate(BooleanType(true)) == BooleanType(true))
        }

        'FalseIsFalse - {
          assert(evaluate(BooleanType(false)) == BooleanType(false))
        }
      }
    }
  }
}
