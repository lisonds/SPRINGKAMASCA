package unsch.edu.pe.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import unsch.edu.pe.model.entity.Materiales;
import unsch.edu.pe.model.entity.Ventas;
import unsch.edu.pe.repositore.MaterialesRepository;
import unsch.edu.pe.repositore.VentasRepository;
import unsch.edu.pe.service.IMaterialesService;

@Service
@Primary
public class MaterialesService implements IMaterialesService {
	@Autowired
	private MaterialesRepository mateRepo;
	
	public void guardar(Materiales materiales) {
		mateRepo.save(materiales);

	}

	
	public List<Materiales> buscarTodas() {
		// TODO Auto-generated method stub
		return mateRepo.findAll();
	}

	
	public Materiales buscarPorId(Integer idmateriales) {
		Optional<Materiales> optional=mateRepo.findById(idmateriales);
		if (optional.isPresent()) {
			return optional.get();
			
		}
		
		return null;
	}

}
