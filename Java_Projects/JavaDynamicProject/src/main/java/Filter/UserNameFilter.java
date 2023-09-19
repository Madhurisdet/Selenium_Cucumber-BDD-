package Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;


public class UserNameFilter extends HttpFilter implements Filter {
       
   
    public UserNameFilter() {
        super();
        
    }

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Enter UserNameFilter");
		if(request.getParameter("firstname").isEmpty(null))
		{
			System.out.println("UserName is empty..!!! Not Proceding");
			return;
		}
		chain.doFilter(request, response);
		System.out.println("Exited UserNameFilter");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
