package com.jese.GameDev.Repositories;

import com.jese.GameDev.Models.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador ,Integer>{

}
