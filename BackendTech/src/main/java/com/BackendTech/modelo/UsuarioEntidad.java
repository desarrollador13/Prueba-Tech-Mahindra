package com.BackendTech.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario")
public class UsuarioEntidad implements Serializable{
	
	private static final long serialVersionUID = -6128077463400689472L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuario_1")
	@SequenceGenerator(name = "Usuario_1", sequenceName = "Usuario", allocationSize = 1)
	@Column(name = "IdUsuario")
	private Long idUsuario;
	@Column(name = "Identificacion")
	private String identificacion;
	@Column(name = "TipoIdentificacion")
	private String tipoIdentificacion;
	@Column(name = "Nombres")
	private String nombres;
	@Column(name = "Apellidos")
	private String apellidos;
	@Column(name = "Usuario")
	private String usuario;
	@Column(name = "Clave")
	private String clave;
	@Column(name = "FechaCreacion")
	private Date fechaCreacion;

}
