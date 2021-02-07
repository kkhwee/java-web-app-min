

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CreateJobListingFilter
 */
public class CreateJobListingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CreateJobListingFilter() {
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
		String title;
		String userName;
		String email;
		String jobDescription;
		String address;
		LocalDateTime reportingDateTime;
		double pay;
		int status;
		
		title = request.getParameter("jobtitle");
		jobDescription = request.getParameter("jobdescription");
		address = request.getParameter("jobaddress");
		
		System.out.println("INside JOB LISTING FILTER");
		
		if(title.length() == 0 || jobDescription.length() == 0 || address.length() == 0)
		{
			((HttpServletResponse) response).sendRedirect("/JobSeekerApp/Homepage/createJobListingErrorPage.jsp");
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
