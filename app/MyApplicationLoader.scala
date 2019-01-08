
import akka.grpc.GrpcClientSettings
import akka.stream.ActorMaterializer
import akkahttp.WebServer
import example.myapp.helloworld.grpc.GreeterServiceClient
import play.api.ApplicationLoader.Context
import play.api._

class MyApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = {
    val components = new MyComponents(context)

    // Starting the server
    WebServer.startServer("localhost", 8080)

    components.application
  }
}

class MyComponents(context: Context) extends BuiltInComponentsFromContext(context) {
  lazy val router = new _root_.router.Routes()

  lazy val materializer = ActorMaterializer()(actorSystem)
  lazy val grpcClientSettings = GrpcClientSettings.connectToServiceAt("localhost", 8080)(actorSystem)
  lazy val greeterServiceClient = GreeterServiceClient(grpcClientSettings)(materializer, scala.concurrent.ExecutionContext.global)
  lazy val homeController = new _root_.controllers.HomeController(scala.concurrent.ExecutionContext.global, greeterServiceClient)

}
