package unsch.edu.pe.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import unsch.edu.pe.model.entity.Ventas;

@Repository
public class VentasDaoImpl implements IVentasDao {
	
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Ventas> findAll() {
		
		return em.createQuery("from Ventas").getResultList();
	}

}
