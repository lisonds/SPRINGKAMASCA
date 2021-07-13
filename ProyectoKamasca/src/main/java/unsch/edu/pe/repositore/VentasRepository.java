package unsch.edu.pe.repositore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import unsch.edu.pe.model.entity.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Integer> {
	List<Ventas> findByProducto(String producto);
}
