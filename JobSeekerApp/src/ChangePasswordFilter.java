

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ChangePasswordFilter
 */
public class ChangePasswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ChangePasswordFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String oldPw = request.getParameter("oldpassword");
		String newPw = request.getParameter("newpassword");
		String confirmPw = request.getParameter("confirmpassword");
		if((!confirmPw.equals(newPw)) || confirmPw.isBlank() || newPw.isBlank() || oldPw.isBlank()) 
		{
			((HttpServletResponse)response).sendRedirect("/JobSeekerApp/common-page/errorPage.jsp");

		}
		else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
