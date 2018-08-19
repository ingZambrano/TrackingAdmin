package mx.com.avior.dbaccesImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.avior.dbacces.ConectionUtil;
import mx.com.avior.dbacces.FuncionesAdmin;
import mx.com.avior.dto.DTOBase;
import mx.com.avior.dto.DTOChip;
import mx.com.avior.dto.DTOCiudades;
import mx.com.avior.dto.DTOCliente;
import mx.com.avior.dto.DTODispositivo;
import mx.com.avior.dto.DTOEstado;
import mx.com.avior.dto.DTOPais;
import mx.com.avior.dto.DTOTelefonica;

@Service
public class FuncionesAdminImpl implements FuncionesAdmin {

	@Autowired
	private ConectionUtil conection;
	
	@Override
	public DTOBase insertaCliente(Object[] params) {
		DTOBase dtoRespuesta = null;
		
		System.out.println("Peticion para inserta cliente");

        try
        {
        	dtoRespuesta = conection.executePauForObject("RIclientes", params);
        }

        catch(Exception e)
        {
        	System.out.println("Error al insertar cliente " + e);
        }

        return dtoRespuesta;
	}

	@Override
	public DTOBase insertaDispositivo(Object[] params) {
		DTOBase dtoRespuesta = null;
		
		System.out.println("Peticion para insertar dispositivos");

        try
        {
        	dtoRespuesta = conection.executePauForObject("RUcatDispositivos", params);
        }

        catch(Exception e)
        {
        	System.out.println("Error al insertar dispositivo " + e);
        }
		
		return dtoRespuesta;
	}
	
	@Override
	public DTOBase insertaEstado(Object[] params) {
		DTOBase dtoRespuesta = null;
		
		System.out.println("Peticion para insertar estado");

        try
        {
        	dtoRespuesta = conection.executePauForObject("RUcatEstados", params);
        }

        catch(Exception e)
        {
        	System.out.println("Error al insertar estado " + e);
        }
		
		return dtoRespuesta;
	}

	
	@Override
	public DTOBase relacionaDispositivoUsuario(Object[] params) {
		DTOBase dtoRespuesta = null;
		
		System.out.println("Peticion para relacionar dispositivos y cliente");
				
        try
        {
        	dtoRespuesta = conection.executePauForObject("RUusuarioDisp", params);
        }

        catch(Exception e)
        {
        	System.out.println("Error al insertar dispositivo " + e);
        }
		
		return dtoRespuesta;
	}

	@Override
	public List<DTODispositivo> listaDispositivos() {
		List<DTODispositivo>  listaDispositivos = null;
		
		System.out.println("Peticion para obtener dispositivos");

        try
        {
        	listaDispositivos = conection.executeQueryForListNoArgs("RScatDispositivos", DTODispositivo.class);
        }

        catch(Exception e)
        {
        	System.out.println("Error al obtener lista de dispositivos " + e);
        }
		
		return listaDispositivos;
		
	}

	@Override
	public List<DTOCliente> listaClientes() {
		List<DTOCliente>  listaClientes = null;
		
		System.out.println("Peticion para obtener clientes");

        try
        {
        	listaClientes = conection.executeQueryForListNoArgs("RScatUsuarios", DTOCliente.class);
        }

        catch(Exception e)
        {
        	System.out.println("Error al obtener lista de dispositivos " + e);
        }
		
		return listaClientes;
	}

	@Override
	public List<DTOCiudades> listaCiudades(HashMap<String, Object> parameters) {
		
		List<DTOCiudades>  listaCiudades = null;
		
		System.out.println("Peticion para obtener lista de ciudades");

        try
        {
        	listaCiudades = conection.executeQueryForList("RScatCiudades", DTOCiudades.class,parameters);
        }

        catch(Exception e)
        {
        	System.out.println("Error al obtener lista de ciudades " + e);
        }
		
		return listaCiudades;
	}
	
		public DTOBase insertaPais(Object[] params) {
		DTOBase dtoRespuesta = null;
		
		System.out.println("Peticion para insertar pais");

        try
        {
        	dtoRespuesta = conection.executePauForObject("RUcatPaises", params);
        }

        catch(Exception e)
        {
        	System.out.println("Error al insertar pais " + e);
        }
		
		return dtoRespuesta;
	}

		@Override
		public List<DTOEstado> listaEstados(HashMap<String,Object> params) {
			List<DTOEstado>  listaEstados = null;
			
			System.out.println("Peticion para obtener lista de Estados");

	        try
	        {
	        	listaEstados = conection.executeQueryForList("RScatEstados", DTOEstado.class,params);
	        	
	        }

	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        	System.out.println("Error al obtener lista de Estados " + e);
	        }
			
			return listaEstados;
		}

		@Override
		public List<DTOPais> listaPaises() {
			List<DTOPais>  listaPaises = null;
			
			System.out.println("Peticion para obtener lista de Pais");

	        try
	        {
	        	listaPaises = conection.executeQueryForListNoArgs("RScatPaises", DTOPais.class);
	        }

	        catch(Exception e)
	        {
	        	System.out.println("Error al obtener lista de Pais " + e);
	        }
			
			return listaPaises;
		}

		@Override
		public DTOBase insertaChip(Object[] params) {

			DTOBase dtoRespuesta = null;
			
			System.out.println("Peticion para insertar chip");

	        try
	        {
	        	dtoRespuesta = conection.executePauForObject("RUcatChips", params);
	        }

	        catch(Exception e)
	        {
	        	System.out.println("Error al insertar chip " + e);
	        }
			
			return dtoRespuesta;
		}

		@Override
		public List<DTOChip> listaChips() {
			List<DTOChip>  listaChips = null;
			
			System.out.println("Peticion para obtener lista de Chips");

	        try
	        {
	        	listaChips = conection.executeQueryForListNoArgs("RScatChips", DTOChip.class);
	        }

	        catch(Exception e)
	        {
	        	System.out.println("Error al obtener lista de Chips " + e);
	        }
			
			return listaChips;
		}

		@Override
		public DTOBase insertaTelefonica(Object[] params) {
			DTOBase dtoRespuesta = null;
			
			System.out.println("Peticion para insertar Telefonicas");

	        try
	        {
	        	dtoRespuesta = conection.executePauForObject("RUcatTelefonicas", params);
	        }

	        catch(Exception e)
	        {
	        	System.out.println("Error al insertar telefonicas " + e);
	        }
			
			return dtoRespuesta;
		}

		@Override
		public List<DTOTelefonica> listaTelefinias() {
			List<DTOTelefonica>  listaTelefonias = null;
			
			System.out.println("Peticion para obtener lista de Chips");

	        try
	        {
	        	listaTelefonias = conection.executeQueryForListNoArgs("RScatTelefinicas", DTOTelefonica.class);
	        }

	        catch(Exception e)
	        {
	        	System.out.println("Error al obtener lista de Chips " + e);
	        }
			
			return listaTelefonias;
		}
	
}
