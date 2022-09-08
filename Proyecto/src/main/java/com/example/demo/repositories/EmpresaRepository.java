package com.example.demo.repositories;

import com.example.demo.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository  extends JpaRepository <Empresa,Integer>{
    @Query(value="select empresa from Empresa empresa where empresa.nit=:nit")
    List<Empresa> findById(int nit);
}
