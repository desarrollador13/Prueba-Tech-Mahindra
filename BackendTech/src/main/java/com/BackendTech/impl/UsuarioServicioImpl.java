package com.BackendTech.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendTech.dto.GeneralResponseDto;
import com.BackendTech.dto.UsuarioRequestDto;
import com.BackendTech.exceptions.LocationException;
import com.BackendTech.exceptions.MessageException;
import com.BackendTech.repositorio.UsuarioRepositorio;
import com.BackendTech.servicio.IUsuarioServicio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public GeneralResponseDto crearUsuario(UsuarioRequestDto usuario)  throws MessageException, LocationException{
		
		if(!camposValidos(usuario)) throw new MessageException("Todos los campos son obligatorios");
		
		if(!tipoIdentificacionValido(usuario.getTipoIdentificacion())) 
			throw new MessageException("Para el Campo Tipo de Identificación valido es Cedula Ciudadanía.");
		try {
			int res = usuarioRepositorio.crearUsuario(
					usuario.getIdentificacion(), usuario.getTipoIdentificacion(), usuario.getNombres(),
					usuario.getApellidos(), usuario.getUsuario(), usuario.getClave());
			System.out.println(res);
			return GeneralResponseDto.builder().codigo(201).mensanje("Exitoso").build();
		}catch (Exception e) {
			throw new MessageException("No es posible crear usuarios, "+ e.getMessage());
		}
	}
	
	
	public Boolean tipoIdentificacionValido(String tipoIdentificacion) {
		if(!tipoIdentificacion.equals("Cedula Ciudadania")) return false;
		return true;
	}
	
	public Boolean camposValidos(UsuarioRequestDto usuario) {
		
		if(usuario.getIdentificacion().isEmpty()) return false;
		if(usuario.getNombres().isEmpty()) return false;
		if(usuario.getApellidos().isEmpty()) return false;
		if(usuario.getTipoIdentificacion().isEmpty()) return false;
		if(usuario.getUsuario().isEmpty()) return false;
		if(usuario.getClave().isEmpty()) return false;
		return true;
	}
	
}
