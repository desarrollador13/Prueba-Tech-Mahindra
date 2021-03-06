package com.BackendTech.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.BackendTech.constante.Endpoint;
import com.BackendTech.dto.GeneralResponseDto;
import com.BackendTech.dto.TareaRequestDto;
import com.BackendTech.exceptions.LocationException;
import com.BackendTech.exceptions.MessageException;
import com.BackendTech.servicio.ITareasServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Endpoint.TASK)
public class TareasControlador{
	
	@Autowired
	private ITareasServicio tareasServicio;
	
	
	@ApiOperation(value = "Guardar datos de tareas", notes = "Retorna codigo de OK o Error")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Exito") })
	@PostMapping
	public ResponseEntity<GeneralResponseDto> crearTarea(
			@RequestBody TareaRequestDto tarea)  throws MessageException, LocationException{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(tareasServicio.crearTarea(tarea));
		} catch (MessageException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }catch (LocationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
	}

}
