package de.codepitbull.gatling.fatjar

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App{
  val props = new GatlingPropertiesBuilder
  props.dataDirectory("jar")
  props.simulationClass(classOf[BasicSimulation].getName)

  Gatling.fromMap(props.build)
  sys.exit()
}
