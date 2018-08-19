package mx.com.avior.dto;


public class DTODispositivo extends DTOBase{
	
	private int fiIdDispositivo;
	private String pi_numeroSerie;
	private String pi_descripcion;
	private String pi_fechaFabricacion;
	private String pi_contrato;
	private boolean pi_idStatus;
	
	
	
	
	public int getFiIdDispositivo() {
		return fiIdDispositivo;
	}
	public void setFiIdDispositivo(int fiIdDispositivo) {
		this.fiIdDispositivo = fiIdDispositivo;
	}
	public String getPi_numeroSerie() {
		return pi_numeroSerie;
	}
	public void setPi_numeroSerie(String pi_numeroSerie) {
		this.pi_numeroSerie = pi_numeroSerie;
	}
	public String getPi_descripcion() {
		return pi_descripcion;
	}
	public void setPi_descripcion(String pi_descripcion) {
		this.pi_descripcion = pi_descripcion;
	}
	public String getPi_fechaFabricacion() {
		return pi_fechaFabricacion;
	}
	public void setPi_fechaFabricacion(String pi_fechaFabricacion) {
		this.pi_fechaFabricacion = pi_fechaFabricacion;
	}
	public String getPi_contrato() {
		return pi_contrato;
	}
	public void setPi_contrato(String pi_contrato) {
		this.pi_contrato = pi_contrato;
	}
	public boolean isPi_idStatus() {
		return pi_idStatus;
	}
	public void setPi_idStatus(boolean pi_idStatus) {
		this.pi_idStatus = pi_idStatus;
	}
		
	
	
}
