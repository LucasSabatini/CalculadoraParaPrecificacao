package br.com.sabatini.model.repository;

import br.com.sabatini.model.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaPrimaRepository extends JpaRepository<RawMaterial, Long> {
}
