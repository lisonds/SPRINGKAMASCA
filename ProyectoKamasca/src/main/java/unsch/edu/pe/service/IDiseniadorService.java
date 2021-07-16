package unsch.edu.pe.service;

import java.util.List;

import unsch.edu.pe.model.entity.Diseniador;


public interface IDiseniadorService {
	void guardar(Diseniador diseniador);
	List<Diseniador> buscarTodas();
	Diseniador buscarPorId(Integer id);
}
