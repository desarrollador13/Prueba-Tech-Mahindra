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

import com.BackendTech.controlador.UsuariosControlador;
import com.BackendTech.dto.GeneralResponseDto;
import com.BackendTech.dto.UsuarioRequestDto;
import com.BackendTech.exceptions.LocationException;
import com.BackendTech.exceptions.MessageException;
import com.BackendTech.servicio.IUsuarioServicio;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UsuariosControladorTests {
	
	@Mock
	private IUsuarioServicio usuarioServicio;
	@InjectMocks
	private UsuariosControlador usuariosControlador;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void guardarDatosUsuario() throws MessageException, LocationException {
		
		int codigo = 201;
		String mensanje = "Exitoso";
		
		GeneralResponseDto generalResponseDto = GeneralResponseDto.builder().codigo(codigo)
				.mensanje(mensanje).build();
		
		String identificacion = "110982722";
		String tipoIdentificacion = "Cedula Ciudadania";
		String nombres = "Jonathan";
		String apellidos = "Pinto Aroca";
		String usuario = "jpinto";
		String clave = "123456789";
		
		UsuarioRequestDto usuarioRequestDto = UsuarioRequestDto.builder()
				.identificacion(identificacion).tipoIdentificacion(tipoIdentificacion).nombres(nombres)
				.apellidos(apellidos).usuario(usuario).clave(clave).build();
		Mockito.when(usuarioServicio.crearUsuario(usuarioRequestDto)).thenReturn(generalResponseDto);
		
		usuariosControlador.crearUsuario(usuarioRequestDto);
		
	}


}
