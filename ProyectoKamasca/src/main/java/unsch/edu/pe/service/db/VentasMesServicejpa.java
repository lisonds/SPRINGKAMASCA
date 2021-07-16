package unsch.edu.pe.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import unsch.edu.pe.model.entity.ventaMes;
import unsch.edu.pe.repositore.VentasMesRepository;
import unsch.edu.pe.service.IVentaMesService;

public class VentasMesServicejpa implements IVentaMesService {
	@Autowired
	private VentasMesRepository ventaMesRepo;
	public void guardar(ventaMes ventasmes) {
		ventaMesRepo.save(ventasmes);

	}

	
	public List<ventaMes> buscarTodas() {
		return ventaMesRepo.findAll();
	}


	
	public ventaMes buscarPorId(Integer idventaMes) {
		Optional<ventaMes> optional=ventaMesRepo.findById(idventaMes);
		if (optional.isPresent()) {
			return optional.get();
			
		}
		
		return null;
	}

	
	
		

}
