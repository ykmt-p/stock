package net.sample_sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class SetEncodingFilter implements Filter {
  @Override
public void init(FilterConfig fConfig) throws ServletException { }
  @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response);
  }
  @Override
public void destroy() { }
}