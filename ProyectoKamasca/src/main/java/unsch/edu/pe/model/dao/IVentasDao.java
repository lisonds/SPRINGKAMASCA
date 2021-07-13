package unsch.edu.pe.model.dao;

import java.util.List;

import unsch.edu.pe.model.entity.Ventas;

public interface IVentasDao {
	public List<Ventas> findAll();
}
