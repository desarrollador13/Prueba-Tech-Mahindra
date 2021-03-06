package com.BackendTech;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.BackendTech.controlador.TareasControlador;
import com.BackendTech.dto.GeneralResponseDto;
import com.BackendTech.dto.TareaRequestDto;
import com.BackendTech.exceptions.LocationException;
import com.BackendTech.exceptions.MessageException;
import com.BackendTech.servicio.ITareasServicio;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TareasControladorTests {
	
	@Mock
	private ITareasServicio tareasServicio;
	@InjectMocks
	private TareasControlador tareasControlador;
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void guardarDatosTareas() throws MessageException, LocationException {
		
		int codigo = 201;
		String mensanje = "Exitoso";
		
		GeneralResponseDto generalResponseDto = GeneralResponseDto.builder().codigo(codigo)
				.mensanje(mensanje).build();
		
		String  idUsuario = "1";
		String nombreTarea = "tarea 1";
		
		TareaRequestDto tareaRequestDto = TareaRequestDto.builder()
				.idUsuario(idUsuario).nombreTarea(nombreTarea).build();
		Mockito.when(tareasServicio.crearTarea(tareaRequestDto)).thenReturn(generalResponseDto);
		
		tareasControlador.crearTarea(tareaRequestDto);
		
	}

}
