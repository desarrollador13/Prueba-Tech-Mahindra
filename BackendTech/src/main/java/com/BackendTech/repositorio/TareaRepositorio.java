package com.BackendTech.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BackendTech.modelo.TareaEntidad;

public interface TareaRepositorio extends JpaRepository<TareaEntidad, Long>{
	
	@Modifying
	 @Transactional
	    @Query(value = "INSERT INTO Tarea (IdUsuario,NombreTarea)"
	    		+ " VALUES(:IdUsuario,:NombreTarea"
	    		+ ")" , nativeQuery = true)
	 public int crearTarea(@Param("IdUsuario")String idUsuario, @Param("NombreTarea")String nombreTarea);

}
