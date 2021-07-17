package unsch.edu.pe.service;

import java.util.List;

import unsch.edu.pe.model.entity.Materiales;


public interface IMaterialesService {
	void guardar(Materiales materiales);
	List<Materiales> buscarTodas();
	Materiales buscarPorId(Integer idmateriales);
}
