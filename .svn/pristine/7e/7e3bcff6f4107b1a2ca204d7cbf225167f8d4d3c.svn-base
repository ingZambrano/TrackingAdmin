package mx.com.avior.security;




import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import mx.com.avior.Impl.UsuarioAviorVO;
import mx.com.avior.dto.DTOUsuario;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("userDetailService")
public class UserDetailService implements UserDetailsService {
	
	@Autowired 
	private SqlSession sqlSession;	
	
	@Autowired
	private HttpServletRequest request;

	@Override
	public UsuarioAviorVO loadUserByUsername(String idUser) throws UsernameNotFoundException {
		// TODO Call to Data Base

		UsuarioAviorVO user=new UsuarioAviorVO();
		
		
		return user;
	}
	
	
	public DTOUsuario autenticaUsuario(String user, String pass){
		
		HashMap<String, Object>  parameters = new HashMap<String, Object>();
		
        String ipCliente = "";
        DTOUsuario usuario = new DTOUsuario();
        
//        HttpServletRequest request = null;
		
			//request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        
        //RequestAttributes reqest = RequestContextHolder.getRequestAttributes();
        
			if (request.getHeader("HTTP_X_FORWARDED_FOR") == null) {
	            ipCliente = request.getRemoteAddr();
	        } else {
	            ipCliente = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	      
		parameters.put("pi_correo", user);
        parameters.put("pi_password", pass);
        parameters.put("pi_usuarioModifico", ipCliente);
        
        System.out.println("Password antes de encriptar: "+pass);
        
        try {
            sqlSession.selectOne("validaUsuario", parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        usuario.setErrorCode(parameters.get("err_num").toString());
        usuario.setErrorMsg((String)parameters.get("err_msg").toString());
        
            if (!usuario.getErrorCode().contentEquals("30000")) {
            	
                System.out.println("Inicio fallido de sesion para: " + user + " con la IP: " + ipCliente + " codigo de error: " + usuario.getErrorCode() + " descripcion de error: " + usuario.getErrorMsg());
            } else {
            	
                System.out.println("Inicio exitoso de sesion para: " + user + " con la IP: " + ipCliente + " codigo de retorno: " + usuario.getErrorCode() + " descripcion de retorno: " + usuario.getErrorMsg());
                
  
                usuario.setIdUser((String)parameters.get("po_idUsuario").toString());
                usuario.setIdProfile((String)parameters.get("po_status").toString());
                //usuario.setPassword((String)parameters.get("pass").toString());
                //usuario.setIdProfile((String)parameters.get("idPerfil").toString());
                usuario.setUsername(user);
                usuario.setProfile((String)parameters.get("po_nombrePerfil").toString());
                
                usuario.addAuthority(usuario.getProfile());
            }
        
		
		return usuario;
	}

}
