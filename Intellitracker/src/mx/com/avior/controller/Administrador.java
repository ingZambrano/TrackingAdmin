package mx.com.avior.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.avior.dbacces.FuncionesAdmin;
import mx.com.avior.dto.DTOBase;
import mx.com.avior.dto.DTOChip;
import mx.com.avior.dto.DTOCiudades;
import mx.com.avior.dto.DTOCliente;
import mx.com.avior.dto.DTODispositivo;
import mx.com.avior.dto.DTOEstado;
import mx.com.avior.dto.DTOPais;
import mx.com.avior.dto.DTOTelefonica;
import mx.com.avior.dto.DTOUsuario;
import mx.com.avior.dto.DTOUsuarioDispositivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("administrador")
public class Administrador {
	
	@Autowired
	private FuncionesAdmin admin; 
	
	@Autowired
	private ShaPasswordEncoder passwordEncoder;	
	
	@RequestMapping(value= "/welcome.go", method=RequestMethod.GET )
	public ModelAndView peticionLogueo(HttpServletRequest request)
	{
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value= "/vistaRegistroUsr.go", method=RequestMethod.POST)
	public ModelAndView vistaRegistroUsr(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("vista", "AltaUsuario");
		return new ModelAndView("vistas");
	}
	
	@RequestMapping(value= "/vistaRegistroDispositivo.go", method=RequestMethod.POST)
	public ModelAndView vistaRegistroDispositivo(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("vista", "AltaDispositivo");
		return new ModelAndView("vistas");
	}
	

	@RequestMapping(value= "/vistaRegDispositivoUsuario.go", method=RequestMethod.POST)
	public ModelAndView vistaRegDispositivoUsuario(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("vista", "vistaRegDispositivoUsuario");
		return new ModelAndView("vistas");
	}
	
	@RequestMapping(value= "/vistaInsertaChip.go", method=RequestMethod.POST)
	public ModelAndView vistaInsertaChip(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("vista", "AltaChip");
		return new ModelAndView("vistas");
	}
	
	@RequestMapping(value= "/vistaRegistraTelefinica.go", method=RequestMethod.POST)
	public ModelAndView vistaRegistraTelefinica(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("vista", "AltaTelefonica");
		return new ModelAndView("vistas");
	}
	
	
	@RequestMapping(value= "/insertaUsuario.go", method=RequestMethod.POST)
	public @ResponseBody DTOBase insertaUsuario(HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DTOUsuario usuario = (DTOUsuario) auth.getPrincipal();
		DTOCliente cliente = new DTOCliente();
		cliente.setPi_correo(request.getParameter("pi_correo"));
		String shaPass = passwordEncoder.encodePassword(request.getParameter("pi_password"),cliente.getPi_correo());
		cliente.setPi_password(shaPass); 
		cliente.setIdPais(Integer.parseInt(request.getParameter("idPais")));
		cliente.setPi_idEstado(Integer.parseInt(request.getParameter("pi_idEstado")));
		cliente.setPi_idCiudad(Integer.parseInt(request.getParameter("pi_idCiudad")));
		cliente.setTelefono(request.getParameter("telefono"));
		

		Object[] params =  {"pi_correo", cliente.getPi_correo(),
				"pi_password", cliente.getPi_password(),
				"pi_idPais", cliente.getIdPais(),
				"pi_idEstado", cliente.getPi_idEstado(),
				"pi_idCiudad", cliente.getPi_idCiudad(),
				"pi_telefono", cliente.getTelefono(),
				"pi_usuarioModifico", usuario.getUsername()}; 
		
		DTOBase dtoBase = admin.insertaCliente(params);
		
		
		return dtoBase;
	}
	
	@RequestMapping(value= "/insertaDispositivo.go", method=RequestMethod.POST)
	public @ResponseBody DTOBase insertaDispositivo(HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DTOUsuario usuario = (DTOUsuario) auth.getPrincipal();
		
		DTODispositivo dispositivo = new DTODispositivo();
		dispositivo.setPi_numeroSerie(request.getParameter("pi_numeroSerie"));    
		dispositivo.setPi_fechaFabricacion(request.getParameter("pi_fechaFabricacion"));
		dispositivo.setPi_descripcion(request.getParameter("pi_descripcion")); 
		dispositivo.setPi_contrato(request.getParameter("pi_contrato"));
		dispositivo.setPi_idStatus(Integer.parseInt(request.getParameter("pi_idStatus"))==0?true:false);

		Object[] params =  {"pi_numeroSerie", dispositivo.getPi_numeroSerie(),
				"pi_fechaFabricacion", dispositivo.getPi_fechaFabricacion(),
				"pi_descripcion", dispositivo.getPi_descripcion(),
				"pi_contrato", dispositivo.getPi_contrato(),
				"pi_idStatus", dispositivo.isPi_idStatus(),
				"pi_usuarioModifico", usuario.getUsername()}; 
		
		
		DTOBase dtoBase = admin.insertaDispositivo(params);
		
		
		return dtoBase;
	}
	
	@RequestMapping(value= "/insertaChip.go", method=RequestMethod.POST)
	public @ResponseBody DTOBase insertaChip(HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DTOUsuario usuario = (DTOUsuario) auth.getPrincipal();
		
		DTOChip chip = new DTOChip();
		chip.setFcNumeroSerie(request.getParameter("pi_numeroSerie"));
		chip.setFcDescripcion(request.getParameter("pi_descripcion"));
		chip.setFiIdTelefonica(Integer.parseInt(request.getParameter("pi_idTelefonica")));
		chip.setFdfechaFabricacion(request.getParameter("pi_fechaFabricacion"));
		chip.setFdFechaRegistro(request.getParameter("pi_fechaRegistro"));
		chip.setPi_numeroTelefonico(request.getParameter("pi_numeroTelefonico"));
		chip.setFiIdStatus(Integer.parseInt(request.getParameter("pi_idStatus")));
		
		
		Object[] params =  {"pi_numeroSerie", chip.getFcNumeroSerie(),
				"pi_descripcion", chip.getFcDescripcion(),
				"pi_idTelefonica", chip.getFiIdTelefonica(),
				"pi_fechaFabricacion", chip.getFdfechaFabricacion(),
				"pi_fechaRegistro", chip.getFdFechaRegistro(),
				"pi_numeroTelefonico",chip.getPi_numeroTelefonico(),
				"pi_idStatus", chip.getFiIdStatus(),
				"pi_usuarioModifico", usuario.getUsername()}; 
		
		
		DTOBase dtoBase = admin.insertaChip(params);
		
		
		return dtoBase;
	}
	
	@RequestMapping(value= "/insertaTelefonia.go", method=RequestMethod.POST)
	public @ResponseBody DTOBase insertaTelefonia(HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DTOUsuario usuario = (DTOUsuario) auth.getPrincipal();
		
		DTOTelefonica telefonica = new DTOTelefonica();
		
		telefonica.setFiId(request.getParameter("pi_id").equals("")? 0 :Integer.parseInt(request.getParameter("pi_id")));
		telefonica.setFcNombre(request.getParameter("pi_nombre"));
		telefonica.setFcDescripcion(request.getParameter("pi_descripcion"));
		telefonica.setFiIdStatus(Integer.parseInt(request.getParameter("pi_idStatus")));
		
		Object[] params =  {"pi_id", telefonica.getFiId(),
				"pi_nombre", telefonica.getFcNombre(),
				"pi_descripcion", telefonica.getFcDescripcion(),
				"pi_idStatus", telefonica.getFiIdStatus(),
				"pi_usuarioModifico", usuario.getUsername()}; 
		
		
		DTOBase dtoBase = admin.insertaTelefonica(params);
		
		
		return dtoBase;
	}

	
	@RequestMapping(value= "/relacionaDispositivoCliente.go", method=RequestMethod.POST)
	public @ResponseBody DTOBase relacionaDispositivoCliente(HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DTOUsuario usuario = (DTOUsuario) auth.getPrincipal();
		
		DTOUsuarioDispositivo dispositivoCliente = new DTOUsuarioDispositivo();
		dispositivoCliente.setPi_id(Integer.parseInt(request.getParameter("pi_id")));    
		dispositivoCliente.setPi_idUsuario(Integer.parseInt(request.getParameter("pi_idUsuario")));
		dispositivoCliente.setPi_numeroSerie(request.getParameter("pi_numeroSerie")); 
		dispositivoCliente.setPi_aliasDisp(request.getParameter("pi_aliasDisp"));
		
		dispositivoCliente.setPi_tiempoActualizacion(Integer.parseInt(request.getParameter("pi_tiempoActualizacion")));    
		dispositivoCliente.setPi_idStatus(Integer.parseInt(request.getParameter("pi_idStatus")));
		dispositivoCliente.setPi_serieChip(request.getParameter("pi_serieChip"));
		
		

		Object[] params =  {"pi_id", dispositivoCliente.getPi_id(),
				"pi_idUsuario", dispositivoCliente.getPi_idUsuario(),
				"pi_numeroSerie", dispositivoCliente.getPi_numeroSerie(),
				"pi_aliasDisp", dispositivoCliente.getPi_aliasDisp(),
				"pi_tiempoActualizacion", dispositivoCliente.getPi_tiempoActualizacion(),
				"pi_idStatus",dispositivoCliente.getPi_idStatus(),
				"pi_serieChip", dispositivoCliente.getPi_serieChip(),
				"pi_usuarioModifico", usuario.getUsername()}; 
		
		DTOBase dtoBase = admin.relacionaDispositivoUsuario(params);
		
		
		return dtoBase;
	}
	
	@RequestMapping(value= "/listaDispositivos.go", method=RequestMethod.POST)
	public @ResponseBody List<DTODispositivo> listaDispositivos(HttpServletRequest request)
	{
		List<DTODispositivo> listaDispositivos = admin.listaDispositivos();
	return listaDispositivos;
	}
	
	@RequestMapping(value= "/listaClientes.go", method=RequestMethod.POST)
	public @ResponseBody List<DTOCliente> listaClientes(HttpServletRequest request)
	{
		List<DTOCliente> listaClientes = admin.listaClientes();
		
	return listaClientes;
	}
	
	@RequestMapping(value= "/listaCiudades.go", method=RequestMethod.POST)
	public @ResponseBody List<DTOCiudades> listaCiudades(HttpServletRequest request)
	{
		int in_idEstado = Integer.parseInt(request.getParameter("in_idEstado"));
		
		HashMap<String,Object> params =  new HashMap<String,Object>();
		params.put("in_idEstado", in_idEstado);
		List<DTOCiudades> listaCiudades = admin.listaCiudades(params);
		
	return listaCiudades;
	}
	
	@RequestMapping(value= "/listaEstados.go", method=RequestMethod.POST)
	public @ResponseBody List<DTOEstado> listaEstados(HttpServletRequest request)
	{
		
		int in_idPais = Integer.parseInt(request.getParameter("in_idPais"));
		System.out.println("Lista de estado: "+in_idPais);
		HashMap<String,Object> params =  new HashMap<String,Object>();
		params.put("in_idPais", in_idPais);
		List<DTOEstado> listaEstados = admin.listaEstados(params);
		
	return listaEstados;
	}
	
	@RequestMapping(value= "/listaPaises.go", method=RequestMethod.POST)
	public @ResponseBody List<DTOPais> listaPaises(HttpServletRequest request)
	{
		List<DTOPais> listaPaises = admin.listaPaises();
		
	return listaPaises;
	}
	
	@RequestMapping(value= "/listaChips.go", method=RequestMethod.POST)
	public @ResponseBody List<DTOChip> listaChips(HttpServletRequest request)
	{
		List<DTOChip> listaChips = admin.listaChips();
		
	return listaChips;
	}
	
	@RequestMapping(value= "/listaTelefonias.go", method=RequestMethod.POST)
	public @ResponseBody List<DTOTelefonica> listaTelefonias(HttpServletRequest request)
	{
		List<DTOTelefonica> listaTelefonias = admin.listaTelefinias();
		
	return listaTelefonias;
	}
	
		@RequestMapping(value= "/insertaEstado.go", method=RequestMethod.POST)
	public @ResponseBody DTOBase insertaEstado(HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DTOUsuario usuario = (DTOUsuario) auth.getPrincipal();
		
		DTOEstado estado = new DTOEstado();
		estado.setPi_id(Integer.parseInt(request.getParameter("pi_id")));
		estado.setPi_nombre(request.getParameter("pi_nombre"));
		estado.setPi_idPais(Integer.parseInt(request.getParameter("pi_idPais")));
		estado.setPi_idStatus(Integer.parseInt(request.getParameter("pi_idStatus"))==1?true:false);
		estado.setPi_usuarioModifico(request.getParameter("pi_usuarioModifico"));
	
		Object[] params =  {"pi_id", estado.getPi_id(),
				"pi_nombre", estado.getPi_nombre(),
				"pi_idPais", estado.getPi_idPais(),
				"pi_idStatus", estado.isPi_idStatus(),
				"pi_usuarioModifico", usuario.getUsername()}; 
		
		DTOBase dtoBase = admin.insertaEstado(params);
			
		return dtoBase;
	}
	
	@RequestMapping(value= "/insertaPais.go", method=RequestMethod.POST)
	public @ResponseBody DTOBase insertaPais(HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DTOUsuario usuario = (DTOUsuario) auth.getPrincipal();
		
		DTOPais pais = new DTOPais();
		pais.setPi_id(Integer.parseInt(request.getParameter("pi_id")));
		pais.setPi_nombre(request.getParameter("pi_nombre"));
		pais.setPi_idStatus(Integer.parseInt(request.getParameter("pi_idStatus"))==1?true:false);
		//pais.setPi_usuarioModifico(request.getParameter("pi_usuarioModifico"));
	
		Object[] params =  {"pi_id", pais.getPi_id(),
				"pi_nombre", pais.getPi_nombre(),
				"pi_idStatus", pais.isPi_idStatus(),
				"pi_usuarioModifico", usuario.getUsername()}; 
		
		DTOBase dtoBase = admin.insertaPais(params);
			
		return dtoBase;
	}
	
	
}
