


import utest._

import Language._

package root {

object TinyLangTests extends TestSuite {
  val tests = Tests {
    'Boolean - {
       'TrueIsTrue - {
         evaluate(BooleanExpr(true)) == BooleanExpr(true)
       }

      'FalseIsFalse - {
        assert(evaluate(BooleanExpr(false)) == BooleanExpr(false))
      }
    }
  }
}
}
