package br.com.sabatini.repository;

import br.com.sabatini.model.entity.RawMaterial;
import br.com.sabatini.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {
    List<RawMaterial> getRawMaterialByUser(User user);
}
