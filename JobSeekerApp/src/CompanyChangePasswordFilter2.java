

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CompanyChangePasswordFilter2
 */
public class CompanyChangePasswordFilter2 implements Filter {

    /**
     * Default constructor. 
     */
    public CompanyChangePasswordFilter2() {
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

		String oldPassword = request.getParameter("oldpwd");
		String newPassword = request.getParameter("newpwd");
		String confirmPassword = request.getParameter("conpwd");
		
		if(oldPassword.length() == 0 || newPassword.length() == 0 || confirmPassword.length() == 0)
		{
			((HttpServletResponse) response).sendRedirect("/JobSeekerApp/Homepage/companyChangePasswordEmptyField.jsp");
		}
		else
		{
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
