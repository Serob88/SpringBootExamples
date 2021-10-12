package com.example.test;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;

@Component
public class SimpleFilter implements Filter {
  @Override
  public void destroy() {}

  @Override
  public void doFilter
      (ServletRequest request, ServletResponse response, FilterChain filterchain)
      throws IOException, ServletException {
    System.out.println("\n" + "Remote Host:"+request.getRemoteHost() + " -> " + LocalDateTime.now());
    System.out.println("Remote Address:"+request.getRemoteAddr() + " -> " + LocalDateTime.now());
    System.out.println("\n" + "_____________________________________________________" + "\n");
    filterchain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig filterconfig) throws ServletException {}
}
