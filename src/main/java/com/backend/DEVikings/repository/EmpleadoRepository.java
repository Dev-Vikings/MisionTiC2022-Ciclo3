package com.backend.DEVikings.repository;

import com.backend.DEVikings.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByCorreo(String correo);

    @Query(value = "SELECT empleado FROM Empleado empleado WHERE empleado.empresa.id=:id" )
    List<Empleado> getEmpleadosFromCompany(Long id);
}
