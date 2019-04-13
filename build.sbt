scalaVersion := "2.11.12"


libraryDependencies += "com.lihaoyi" %%% "utest" % "0.6.7" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true

enablePlugins(ScalaNativePlugin)
