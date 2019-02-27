package io.radicalbit
import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
abstract class BaseBench {

  @Param
  var arg: InputArg = InputArg.Tiny

  var nullObject: Object = null
}
