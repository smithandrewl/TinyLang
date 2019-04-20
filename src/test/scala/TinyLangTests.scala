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
    }
  }
}
