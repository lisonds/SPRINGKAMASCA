package unsch.edu.pe.service;

import java.util.List;

import unsch.edu.pe.model.entity.ventaMes;



public interface IVentaMesService {
	void guardar(ventaMes ventasmes);
	List<ventaMes> buscarTodas();
	ventaMes buscarPorId(Integer idventaMes);
}
