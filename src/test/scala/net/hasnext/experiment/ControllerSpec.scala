import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ControllerSpec extends Spec with ShouldMatchers {
  describe("A controller method") {
    class MyInputModel

    class RequestPipeline {
      def processRequest(url : String) {
        var controller = new MyController
        controller.myAction(new MyInputModel)
      }
    }

    class MyController {
      def myAction(input : MyInputModel) {
        Record.called = true 
      }
    }

    object Record {
      var called: Boolean = false
    }

    describe("when input parameter is registered") {
      
      val requestPipeline = new RequestPipeline()
      
      describe("when url invoked") {
        requestPipeline.processRequest("/myurl")
        it("should call action method"){
          Record.called should be (true)
        }
      }
    }
  }
}
