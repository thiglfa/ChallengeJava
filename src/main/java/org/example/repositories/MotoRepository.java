package org.example.repositories;

import org.example.domainmodel.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
    boolean existsByPlaca(String placa);
}
