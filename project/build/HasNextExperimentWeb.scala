import sbt._

class HasNextExperimentWeb(info: ProjectInfo) extends DefaultWebProject(info) {
  val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided"
  val jetty7 = "org.eclipse.jetty" % "jetty-webapp" % "7.0.2.RC0" % "test"
  val scalatest = "org.scalatest" % "scalatest" % "1.2" % "test"
}
