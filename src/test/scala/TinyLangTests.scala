
package test.utest.examples

import utest._
object TinyLangTests extends TestSuite {
  val tests = Tests {
    'test1 - {
      throw new Exception("test1")
    }
    'test2 - {
      1
    }
  }
}
