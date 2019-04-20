import utest._
import Language._

package root {
  object EqualityTests extends TestSuite {
    val tests = Tests {
      'EqualityTests - {
        'Integer {
          'ZeroEqualsZero - {
            assert(
              evaluate(Equals(IntegerType(0), IntegerType(0))) == BooleanType(true)
            )
          }
          'OneDNEZero - {
            assert(
              evaluate(Equals(IntegerType(1), IntegerType(0))) == BooleanType(false)
            )
          }
          'ZeroDNEOne - {
            assert(
              evaluate(Equals(IntegerType(0), IntegerType(1))) == BooleanType(false)
            )
          }
          'OneEqualsOne - {
            assert(
              evaluate(Equals(IntegerType(1), IntegerType(1))) == BooleanType(true)
            )
          }
        }
        'Boolean {
          'FalseEqualsFalse - {
            assert(
              evaluate(Equals(BooleanType(false), BooleanType(false))) == BooleanType(true)
            )
          }
          'TrueEqualsTrue - {
            assert(
              evaluate(Equals(BooleanType(true), BooleanType(true))) == BooleanType(true)
            )
          }
          'FalseDNETrue - {
            assert(
              evaluate(Equals(BooleanType(false), BooleanType(true))) == BooleanType(false)
            )
          }
          'TrueDNEFalse - {
            assert(
              evaluate(Equals(BooleanType(true), BooleanType(false))) == BooleanType(false)
            )
          }
        }
      }
    }
  }
}