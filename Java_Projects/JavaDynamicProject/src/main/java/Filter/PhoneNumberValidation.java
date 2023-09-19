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


public class PhoneNumberValidation extends HttpFilter implements Filter {
       
   public PhoneNumberValidation() {
        super();
        }
   
    public void destroy() {
		
	}
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Entered phone number");
	
		}
		chain.doFilter(request, response);
		System.out.println("Exited phone number");
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
