package com.BackendTech.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Tarea")
public class TareaEntidad implements Serializable{
	
	private static final long serialVersionUID = -6128077463400689472L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tarea_1")
	@SequenceGenerator(name = "Tarea_1", sequenceName = "Tarea", allocationSize = 1)
	@Column(name = "IdTarea")
	private Long IdTarea;
	@Column(name = "IdUsuario")
	private Long idUsuario;
	@Column(name = "NombreTarea")
	private String nombreTarea;
	@Column(name = "FechaCreacion")
	private Date FechaCreacion;
	
	@ManyToOne
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario", insertable = false, updatable = false, nullable = true)
	private UsuarioEntidad usuario;

}
