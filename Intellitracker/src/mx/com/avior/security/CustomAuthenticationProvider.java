package mx.com.avior.security;

import mx.com.avior.dto.DTOUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Repository;

@Repository
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
    private UserDetailService userService;
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
        password = passwordEncoder.encodePassword(password, username);
   
        
        DTOUsuario miUsuario = userService.autenticaUsuario(username,password); 
 
        if (!miUsuario.getErrorCode().equals("30000")) {
            throw new BadCredentialsException(miUsuario.getErrorMsg());
        }else{
        	//user = userService.loadUserByUsername(username+","+miUsuario.toString());
        	System.out.println("Carga roll usuario.....");
        }
 
        
        return new UsernamePasswordAuthenticationToken(miUsuario, password, miUsuario.getAuthorities());
    }
 
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
