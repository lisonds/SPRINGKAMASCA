package unsch.edu.pe.service;

import java.util.List;

import unsch.edu.pe.model.entity.Ventas;

public interface IventasService {
	void guardar(Ventas ventas);
	List<Ventas> buscarTodas();
	Ventas buscarPorId(Integer idventas);
	
}
