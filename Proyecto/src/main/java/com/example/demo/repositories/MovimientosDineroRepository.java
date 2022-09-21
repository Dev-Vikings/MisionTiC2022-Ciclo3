package com.example.demo.repositories;

import com.example.demo.entities.Empleado;
import com.example.demo.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientosDineroRepository extends JpaRepository<MovimientoDinero,Integer> {


    @Query(value="select empleado from Empleado empleado where empleado.id=:id")
    List<Empleado> getEmpleadoById(int id);
}
