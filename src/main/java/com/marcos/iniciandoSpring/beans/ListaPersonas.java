package com.marcos.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaPersonas {

	
	private static List <Persona> lista = null;
	
	
	private ListaPersonas() {
		List <Persona>  construida= new ArrayList <Persona>();
		construirLista(construida);
		ListaPersonas.lista = construida;
		System.out.println("Construida la lista personas");
	}
	
	
	public List<Persona> construirLista(List <Persona> listaPersonas){
		
		Persona perso = new Persona();
		perso.setId(0);
		perso.setNombre("Maria Gomez");
		perso.setEmail("maria@hola.com ");
		perso.setCiudad("Oviedo");
		perso.setTelefono("666555777");
		listaPersonas.add(perso);
		
		Persona perso1 = new Persona();
		perso1.setId(1);
		perso1.setNombre("Paco Perez");
		perso1.setEmail("paco@hola.com");
		perso1.setCiudad("Gijón");
		perso1.setTelefono("666888222");
		listaPersonas.add(perso1);
		
		Persona perso2 = new Persona();
		perso2.setId(2);
		perso2.setNombre("Elena Montiel");
		perso2.setEmail(" elena@hola.com");
		perso2.setCiudad("Madrid");
		perso2.setTelefono("666111444");
		listaPersonas.add(perso2);
		
		Persona perso3 = new Persona();
		perso3.setId(3);
		perso3.setNombre("Samu Sanchez");
		perso3.setEmail("samu@hola.com");
		perso3.setCiudad("Oviedo");
		perso3.setTelefono("666888000");
		listaPersonas.add(perso3);
		
		Persona perso4 = new Persona();
		perso4.setId(4);
		perso4.setNombre("Eva Alvarez");
		perso4.setEmail("eva@hola.com");
		perso4.setCiudad("Luarca");
		perso4.setTelefono("666444222");
		listaPersonas.add(perso4);
		
		return listaPersonas;
	}
	
	
	
	public static List<Persona> getPersonas(){
		
		if(lista == null) {
			
			new ListaPersonas();
			System.out.println("La lista personas ha sido construido");
		}
		return lista;
	}
	
	public static String del(int id) {
		List <Persona> listaPersonas = new ArrayList <Persona>(); 
		Iterator <Persona> it = ListaPersonas.lista.iterator();
		Persona persona = new Persona();
		String nombre = null;
		while(it.hasNext()) {
			persona = it.next();
			if(persona.getId() != id) {
				listaPersonas.add(persona);
			}
			else {
				nombre = persona.getNombre();
			}
			
		}
		ListaPersonas.lista = listaPersonas;
		return nombre;
	}
	
	
	public static Persona viewPersona(int id) {
		Persona persona = new Persona();
		Persona salida = new Persona();
		Iterator <Persona> it = ListaPersonas.lista.iterator();
		while(it.hasNext()) {
			persona= it.next();
			if(persona.getId()==id) {
				salida = persona;
			}
		}
		return salida;
	}
	
}

/*
0 Maria Gomez maria@hola.com Oviedo 666555777
1 Paco Perez paco@hola.com Gijón 666888222
2 Elena Montiel elena@hola.com Madrid 666111444
3 Samu Sanchez samu@hola.com Oviedo 666888000
4 Eva Alvarez eva@hola.com Luarca 666444222
 */








