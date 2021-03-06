package com.BackendTech.servicio;

import com.BackendTech.dto.FiltroRequestDto;
import com.BackendTech.dto.GeneralResponseDto;
import com.BackendTech.dto.UsuarioRequestDto;
import com.BackendTech.exceptions.LocationException;
import com.BackendTech.exceptions.MessageException;

public interface IUsuarioServicio {
	
	GeneralResponseDto crearUsuario(UsuarioRequestDto usuario)throws MessageException, LocationException;
	
}
