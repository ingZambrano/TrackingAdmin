package mx.com.avior.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.avior.Impl.UsuarioAviorVO;
import mx.com.avior.dto.DTOUsuario;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Repository;



@Repository
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	 RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	 

	    protected void handle(HttpServletRequest request,
	            HttpServletResponse response, Authentication authentication)
	            throws IOException, ServletException {
	        String targetUrl = determineTargetUrl(authentication);

	        if (response.isCommitted()) {
	            System.out.println("Response has already been committed Unable to redirect to "+ targetUrl);
	            return;
	        }

	        DTOUsuario pcbvo = (DTOUsuario) authentication.getPrincipal();
	        
	
		       String ipCliente = null;
		       
		      
					if (request.getHeader("HTTP_X_FORWARDED_FOR") == null) {
			            ipCliente =  request.getRemoteAddr();
			        } else {
			            ipCliente = request.getHeader("HTTP_X_FORWARDED_FOR");
			        }
					
		       
		       pcbvo.setIpcliente(ipCliente);
	        
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }

	    private String determineTargetUrl(Authentication authentication) {

	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        for (GrantedAuthority authority : authorities) {
	            if (authority.getAuthority().equals("ROLE_ADMIN")) {
	                return "/administrador/welcome.go";
	            } else {
	                return "";
	            }
	        }
	        return null;
	    }
}