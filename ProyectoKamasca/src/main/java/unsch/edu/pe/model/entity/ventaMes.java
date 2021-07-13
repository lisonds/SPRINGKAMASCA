package unsch.edu.pe.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventaMes")
public class ventaMes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idventaMes;
	private String mes;
	private double ganancia;

	public int getIdventaMes() {
		return idventaMes;
	}

	public void setIdventaMes(int idventaMes) {
		this.idventaMes = idventaMes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getGanancia() {
		return ganancia;
	}

	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}

}
