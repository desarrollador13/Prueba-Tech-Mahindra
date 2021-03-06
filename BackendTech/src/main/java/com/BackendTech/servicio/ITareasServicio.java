package com.BackendTech.servicio;

import com.BackendTech.dto.GeneralResponseDto;
import com.BackendTech.dto.TareaRequestDto;
import com.BackendTech.exceptions.LocationException;
import com.BackendTech.exceptions.MessageException;

public interface ITareasServicio {
	
	GeneralResponseDto crearTarea(TareaRequestDto tarea)throws MessageException, LocationException;
	
}
