package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String uri = httpServletRequest.getRequestURI();
        String token = httpServletRequest.getHeader("TOKEN");

        System.out.println(objectMapper == null);
        if(token != null){
            System.out.println("token: " + token);
        }
        if (uri.equals("/check_token" )){
            System.out.println("------check token---");
            if (!(token != null && token.equals("itellyou"))) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("message", "Invalid token");

                httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
                objectMapper.writeValue(httpServletResponse.getWriter(), errorDetails);
                return;
            }
        }
        System.out.println("Request URI is: " + uri);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("Response Status Code is: " + httpServletResponse.getStatus());
    }
}