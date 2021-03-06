package com.BackendTech.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendTech.dto.GeneralResponseDto;
import com.BackendTech.dto.TareaRequestDto;
import com.BackendTech.exceptions.LocationException;
import com.BackendTech.exceptions.MessageException;
import com.BackendTech.repositorio.TareaRepositorio;
import com.BackendTech.servicio.ITareasServicio;

@Service
public class TareaServicioImpl implements ITareasServicio{
	
	@Autowired
	TareaRepositorio tareaRepositorio;

	@Override
	public GeneralResponseDto crearTarea(TareaRequestDto tarea) throws MessageException, LocationException {
		if(!camposValidos(tarea)) {
			System.out.println("Entro aca !");
			throw new MessageException("Todos los campos son obligatorios");
		}
		try {
			int res = tareaRepositorio.crearTarea(tarea.getIdUsuario(), tarea.getNombreTarea());
			System.out.println(res);
			return GeneralResponseDto.builder().codigo(201).mensanje("Exitoso").build();
		}catch (Exception e) {
			throw new MessageException("No es posible crear Tareas, "+ e.getMessage());
		}
	}
	
	
    public Boolean camposValidos(TareaRequestDto tarea) {
		
		if(tarea.getIdUsuario().isEmpty()) return false;
		if(tarea.getNombreTarea().isEmpty()) return false;
		return true;
	}

}
