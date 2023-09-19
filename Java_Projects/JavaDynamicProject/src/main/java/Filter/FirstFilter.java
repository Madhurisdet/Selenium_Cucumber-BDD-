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


public class FirstFilter extends HttpFilter implements Filter {
       
   
    public FirstFilter() {
        super();  
        System.out.println("MyFirstFilter.MyFirstFilter()...");
    }

	public void destroy() {
		System.out.println("MyFirstFilter.destroy()...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFirstFilter.doFilter......request goint in...");
		chain.doFilter(request, response);
		System.out.println("MyFirstFilter.doFilter......response goint out...");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFirstFilter.init()...");
		
	}

}
