package mx.com.avior.dto;

public class DTOCliente extends DTOBase{
	
	 private int id_Cliente;
	 private String pi_correo;
	 private String pi_password;
	 private int idPais;
	 private int pi_idEstado;
	 private int pi_idCiudad;
	 private String telefono;
	 private int pi_idStatus;
	 
	
	 
	
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public String getPi_correo() {
		return pi_correo;
	}
	public void setPi_correo(String pi_correo) {
		this.pi_correo = pi_correo;
	}
	public String getPi_password() {
		return pi_password;
	}
	public void setPi_password(String pi_password) {
		this.pi_password = pi_password;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public int getPi_idEstado() {
		return pi_idEstado;
	}
	public void setPi_idEstado(int pi_idEstado) {
		this.pi_idEstado = pi_idEstado;
	}
	public int getPi_idCiudad() {
		return pi_idCiudad;
	}
	public void setPi_idCiudad(int pi_idCiudad) {
		this.pi_idCiudad = pi_idCiudad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getPi_idStatus() {
		return pi_idStatus;
	}
	public void setPi_idStatus(int pi_idStatus) {
		this.pi_idStatus = pi_idStatus;
	}
	
	
	 
	 
}
