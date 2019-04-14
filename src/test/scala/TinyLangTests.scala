


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
      'FalseAndBooleanIsFalse - {
        assert(evaluate(AndOperation(BooleanType(false), BooleanType(false))) == BooleanType(false))
        assert(evaluate(AndOperation(BooleanType(false), BooleanType(true))) == BooleanType(false))
      }
    }
  }
}
}
