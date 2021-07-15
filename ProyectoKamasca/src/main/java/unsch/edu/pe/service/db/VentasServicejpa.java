package unsch.edu.pe.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import unsch.edu.pe.model.entity.Ventas;
import unsch.edu.pe.repositore.VentasRepository;
import unsch.edu.pe.service.IventasService;

@Service
@Primary
public class VentasServicejpa implements IventasService {
	 
	@Autowired
	private VentasRepository ventasRepo;
	
	
	public void guardar(Ventas ventas) {
		ventasRepo.save(ventas);
		// TODO Auto-generated method stub

	}

	
	public List<Ventas> buscarTodas() {
		
		return ventasRepo.findAll();
	}

	
	public Ventas buscarPorId(Integer idventas) {
		Optional<Ventas> optional=ventasRepo.findById(idventas);
		if (optional.isPresent()) {
			return optional.get();
			
		}
		
		return null;
	}


	
	
	
}
