package com.BackendTech.constante;

import lombok.Builder;

@Builder
public class Endpoint {

	private Endpoint() {}
	
	public static final String USERS = "/users/";
	public static final String TASK = "/tareas/";
}
