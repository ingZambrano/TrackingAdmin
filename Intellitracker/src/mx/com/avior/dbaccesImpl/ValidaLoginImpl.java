package mx.com.avior.dbaccesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.avior.dbacces.ConectionUtil;
import mx.com.avior.dbacces.ValidaLogin;
import mx.com.avior.dto.DTOBase;

@Service
public class ValidaLoginImpl implements ValidaLogin {
	
	@Autowired
	 private ConectionUtil conection;
	
	
	@Override
	public DTOBase validaUsuario(Object[] params) {
		DTOBase dtobase = null;
        try {
        	//dtobase = conection.executeQueryForObject("saveTitular", DTOBase.class, params);
        } catch (Exception e) {
            //System.out.println("Error al generar titular para contrato  "+e);
        }
        return dtobase;
	}

}
