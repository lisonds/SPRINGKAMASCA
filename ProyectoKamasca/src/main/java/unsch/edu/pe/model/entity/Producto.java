package unsch.edu.pe.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	private int idproductos;
	private String nombredelproduc;
	private String Descripcion;
	private String fotoproduc;

	@OneToOne
	@JoinColumn(name = "ventas_idventas")
	private Ventas ventas;

	public int getIdproductos() {
		return idproductos;
	}

	public void setIdproductos(int idproductos) {
		this.idproductos = idproductos;
	}

	public String getNombredelproduc() {
		return nombredelproduc;
	}

	public void setNombredelproduc(String nombredelproduc) {
		this.nombredelproduc = nombredelproduc;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getFotoproduc() {
		return fotoproduc;
	}

	public void setFotoproduc(String fotoproduc) {
		this.fotoproduc = fotoproduc;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}

}
