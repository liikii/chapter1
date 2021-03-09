package example;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class TokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String token = httpServletRequest.getHeader("TOKEN");
        boolean b = token == null;

        if(!b){
            System.out.println("has a token: " + token);
        }else {
            System.out.println("no token");
        }
        System.out.println("Request URI is: " + httpServletRequest.getRequestURI());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("Response Status Code is: " + httpServletResponse.getStatus());
    }
}