package io.radicalbit

import org.log4s.Logger
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

class BenchLog4s extends BaseBench {

  lazy val log4s: Logger = org.log4s.getLogger

  @Benchmark
  @OperationsPerInvocation(1)
  def one_variable_interpolation(hole: Blackhole): Unit = {
    hole.consume(
      log4s.info(s"This is a log with variable interpolation ${arg.value1}")
    )
  }

  @Benchmark
  @OperationsPerInvocation(1)
  def two_variable_interpolation(hole: Blackhole): Unit = {
    hole.consume(
      log4s.info(
        s"This is a log with variable interpolation ${arg.value1} and ${arg.value2}"
      )
    )
  }

  @Benchmark
  @OperationsPerInvocation(1)
  def three_variable_and_null_interpolation(hole: Blackhole): Unit = {
    hole.consume(
      log4s.info(
        s"This is a log with variable interpolation ${arg.value1} and ${arg.value2} and null {$nullObject}"
      )
    )
  }

}
