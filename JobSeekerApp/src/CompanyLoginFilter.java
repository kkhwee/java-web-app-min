

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CompanyLoginFilter
 */
public class CompanyLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CompanyLoginFilter() {
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

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);
		
		if(email.length() == 0 || password.length() == 0)
		{
			// need to type cast ServletResponse to HttpServletResponse
			((HttpServletResponse) response).sendRedirect("/JobSeekerApp/companyLoginEmptyFieldError.html");
		} 
		else
		{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
		
//		if(!email.contains("@"))
//		{
//			((HttpServletResponse) response).sendRedirect("/JobSeekerApp/companyRegistrationInvalidEmailError.html");
//		} 
//		else
//		{
//			// pass the request along the filter chain
//			chain.doFilter(request, response);
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
