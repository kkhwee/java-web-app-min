

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CompanyEditJobListingFilter
 */
public class CompanyEditJobListingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CompanyEditJobListingFilter() {
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
		String jobID = request.getParameter("jobID");
		String title = request.getParameter("jobtitle");
		String desc = request.getParameter("jobdescription");
		String address = request.getParameter("jobaddress");
		String dateTime = request.getParameter("jobdatetime");
		String pay = request.getParameter("jobpay");
		
		if(jobID.length() == 0 || 
				title.length() == 0 || 
				desc.length() == 0 || 
				address.length()==0 || 
				dateTime.length() == 0 || 
				pay.length()==0)
		{
			// need to type cast ServletResponse to HttpServletResponse
			((HttpServletResponse) response).sendRedirect("/JobSeekerApp/JobListing/editJobListingErrorPage.jsp");
		} 
		else
		{
			// pass the request along the filter chain
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
