package mx.com.avior.dbacces;

import java.util.HashMap;
import java.util.List;

import mx.com.avior.dto.DTOBase;
import mx.com.avior.dto.DTOChip;
import mx.com.avior.dto.DTOCiudades;
import mx.com.avior.dto.DTOCliente;
import mx.com.avior.dto.DTODispositivo;
import mx.com.avior.dto.DTOEstado;
import mx.com.avior.dto.DTOPais;
import mx.com.avior.dto.DTOTelefonica;

public interface FuncionesAdmin {
	DTOBase insertaCliente(Object[] params);
	DTOBase insertaDispositivo(Object[] params);
	DTOBase insertaEstado(Object[] params);
	DTOBase insertaPais(Object[] params);
	DTOBase insertaChip(Object[] params);
	DTOBase insertaTelefonica(Object[] params);
	DTOBase relacionaDispositivoUsuario(Object[] params);
	List<DTODispositivo> listaDispositivos();
	List<DTOCliente> listaClientes();
	List<DTOCiudades> listaCiudades(HashMap<String, Object> parameters);
	List<DTOEstado> listaEstados(HashMap<String,Object> params);
	List<DTOPais> listaPaises();
	List<DTOChip> listaChips();
	List<DTOTelefonica> listaTelefinias();
 }
