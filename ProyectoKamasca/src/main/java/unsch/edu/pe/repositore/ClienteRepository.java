package unsch.edu.pe.repositore;

import org.springframework.data.jpa.repository.JpaRepository;

import unsch.edu.pe.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
