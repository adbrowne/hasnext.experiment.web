import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

trait Route {
  def getUrl(inputModel : AnyRef) : Option[String]
}

class MyRoute extends Route {
  import scala.collection.mutable.HashMap 
  val routeTable = new HashMap[Class[_],String]
  def getUrl(inputModel : AnyRef) = {
      for(i <- routeTable.keys)
        println(i)
      println(routeTable.keys)
      routeTable get inputModel.getClass
  }

  def register(inputModel : Class[_], url : String){
    routeTable += (inputModel -> url)
  }
}

class MyInputModel

class RouteSpec extends Spec with ShouldMatchers {
  describe("A route") {
    describe("(when empty)") {
      val myRoute = new MyRoute
      it("should return None") {
        myRoute.getUrl(new Object) should be (None)
      }
    }

    describe("(when registered)") {
      val myRoute = new MyRoute
      myRoute.register(classOf[MyInputModel], "/inputtest")
      it("should return url") {
        myRoute.getUrl(new MyInputModel) should be (Some("/inputtest"))
      }
    }
  }
}

