package unsch.edu.pe.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import unsch.edu.pe.model.entity.Diseniador;

import unsch.edu.pe.repositore.DiseniadorRepository;
import unsch.edu.pe.service.IDiseniadorService;

@Service
@Primary
public class DiseniadorService implements IDiseniadorService {

	@Autowired
	private DiseniadorRepository diseRepo;
	
	
	public void guardar(Diseniador diseniador) {
		// TODO Auto-generated method stub
		diseRepo.save(diseniador);
	}

	
	public List<Diseniador> buscarTodas() {
		return diseRepo.findAll();
	}

	
	public Diseniador buscarPorId(Integer id) {
		Optional<Diseniador> optional=diseRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
			
		}
		
		return null;
	}
	

}
