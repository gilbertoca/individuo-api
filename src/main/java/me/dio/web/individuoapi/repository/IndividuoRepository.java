package me.dio.web.individuoapi.repository;

import me.dio.web.individuoapi.entity.Individuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividuoRepository extends JpaRepository<Individuo, Long> {
    
}
