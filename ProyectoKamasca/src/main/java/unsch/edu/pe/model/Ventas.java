package unsch.edu.pe.model;

import java.util.Date;



public class Ventas {
	private Integer numBoleta;
	private String producto;
	private String clasificacion;
	private Date fecha;
	private Double costo;
	private Integer cancelado;
	
	
	
	public Integer getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(Integer numBoleta) {
		this.numBoleta = numBoleta;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Integer getCancelado() {
		return cancelado;
	}
	public void setCancelado(Integer cancelado) {
		this.cancelado = cancelado;
	}
	
	
	@Override
	public String toString() {
		return "Ventas [numBoleta=" + numBoleta + ", producto=" + producto + ", clasificacion=" + clasificacion
				+ ", fecha=" + fecha + ", costo=" + costo + ", cancelado=" + cancelado + "]";
	}
	
	
	
	
	
	
	
	
	
}
