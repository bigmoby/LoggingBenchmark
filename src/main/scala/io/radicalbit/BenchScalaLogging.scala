package io.radicalbit

import com.typesafe.scalalogging.Logger
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

class BenchScalaLogging extends BaseBench {
  
  val logger = Logger(classOf[BenchScalaLogging])

  @Benchmark
  @OperationsPerInvocation(1)
  def one_variable_interpolation(hole: Blackhole): Unit = {
    hole.consume(
      logger.info(s"This is a log with variable interpolation ${arg.value1}")
    )
  }

  @Benchmark
  @OperationsPerInvocation(1)
  def one_variable_placeholder(hole: Blackhole): Unit = {
    hole.consume(
      logger
        .info(s"This is a log with variable substitution {}", arg.value1: Any)
    )
  }

  @Benchmark
  @OperationsPerInvocation(1)
  def two_variable_interpolation(hole: Blackhole): Unit = {
    hole.consume(
      logger.info(
        s"This is a log with variable interpolation ${arg.value1} and ${arg.value2}"
      )
    )
  }

  @Benchmark
  @OperationsPerInvocation(1)
  def two_variable_placeholder(hole: Blackhole): Unit = {
    hole.consume(
      logger.info(
        s"This is a log with variable placeholder",
        arg.value1: Any,
        arg.value2: Any
      )
    )
  }

  @Benchmark
  @OperationsPerInvocation(1)
  def three_variable_and_null_interpolation(hole: Blackhole): Unit = {
    hole.consume(
      logger.info(
        s"This is a log with variable substitution ${arg.value1} and ${arg.value2} and null {$nullObject}"
      )
    )
  }

  @Benchmark
  @OperationsPerInvocation(1)
  def three_variable_and_null_placeholder(hole: Blackhole): Unit = {
    hole.consume(
      logger.info(
        s"This is a log with variable placeholder",
        Array[AnyRef](arg.value1, arg.value2, nullObject): _*
      )
    )
  }

}
