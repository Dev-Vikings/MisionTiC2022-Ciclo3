package com.backend.DEVikings.repository;

import com.backend.DEVikings.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    @Query(value = "SELECT transaccion FROM Transaccion transaccion WHERE transaccion.id=:id" )
    List<Transaccion> getTransaccionById(Long id);

    @Query(value = "SELECT transaccion FROM Transaccion transaccion WHERE transaccion.empleado.empresa.id=:id" )
    List<Transaccion> getTransaccionByCompanyId(Long id);
}
