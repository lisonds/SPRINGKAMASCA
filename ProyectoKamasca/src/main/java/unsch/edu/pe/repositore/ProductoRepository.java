package unsch.edu.pe.repositore;

import org.springframework.data.jpa.repository.JpaRepository;

import unsch.edu.pe.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
