import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import javax.servlet._

package net.hasnext.experiment.web
{
  class WebFilter extends Filter{

    def init(filterConfig: FilterConfig) : Unit = {
      println(">init");
    }
    def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) = {
      val httpRequest = request.asInstanceOf[HttpServletRequest]
      val httpResponse = response.asInstanceOf[HttpServletResponse]

      println(httpRequest)

      response.getWriter().write("Message of the day!")
    }

    def destroy() : Unit = {
      println("> ClassicScalaFilter: destroy()");
    }

  }
}
