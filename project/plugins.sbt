resolvers += Resolver.sonatypeRepo("releases")

dependencyOverrides += "com.typesafe.play" %% "twirl-api" % "1.1.1"
//dependencyOverrides += "com.typesafe.play" %% "twirl-api" % "1.3.13"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.3")

// Akka GRPC
addSbtPlugin("com.lightbend.akka.grpc" %% "sbt-akka-grpc" % "0.4.2+32-1db281de")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")

