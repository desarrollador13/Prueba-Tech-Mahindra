package com.BackendTech.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BackendTech.modelo.UsuarioEntidad;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, Long>{
	
	
	 @Modifying
	 @Transactional
	    @Query(value = "INSERT INTO Usuario (Identificacion,TipoIdentificacion, Nombres, Apellidos, Usuario, Clave)"
	    		+ " VALUES(:Identificacion,:TipoIdentificacion,:Nombres,:Apellidos,:Usuario,:Clave"
	    		+ ")" , nativeQuery = true)
	 public int crearUsuario(@Param("Identificacion")String identificacion, @Param("TipoIdentificacion")String tipoIdentificacion, 
			 @Param("Nombres")String nombres,@Param("Apellidos")String apellidos, 
			 @Param("Usuario")String usuario,@Param("Clave")String clave);

}
