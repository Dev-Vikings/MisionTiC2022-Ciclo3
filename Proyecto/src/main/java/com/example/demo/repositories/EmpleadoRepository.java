package com.example.demo.repositories;

import com.example.demo.entities.Empleado;
import com.example.demo.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado,Integer> {

//    @Query(value = "SELECT empresa FROM Empleado empleado JOIN empleado.empresa empresa where empresa.id = :id")
@Query(value="select empresa from Empresa empresa where empresa.id=:id")
    List<Empresa> getEmpresasById(int id);
}
