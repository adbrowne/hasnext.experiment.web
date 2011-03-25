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

      response.getWriter().write("""Q:  Why did the programmer call his mother long distance?
A:  Because that was her name. -- aaron was here""")

    }

    def destroy() : Unit = {
      println("> ClassicScalaFilter: destroy()");
    }

  }
}
