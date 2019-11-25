package com.marcos.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ListaAutores {

	
	private static List<Autor> lista = null;


	/**
	 * Devuelve un autor en concreto
	 * @param id
	 * @return 
	 * @return 
	 */
	
	/*
	public static Autor getAutor(int id) {
		
		return lista.get(id);
		
	}
	*/


	/**
	 * Devuleve a todos los autores
	 * @return
	 */
	
	private ListaAutores() {
		List<Autor> lista = new ArrayList<Autor>();
		construirLista(lista);
		ListaAutores.lista= lista;
	}
	
		
	public int aleatorio() {
		Random r= new Random();
		
		int random = r.nextInt(101)+1;
		int valor = random;
		List<Integer> numeros = new ArrayList<>();
		if (numeros.contains(valor)) {
			
		while(numeros.contains(valor)) {
		      valor = random;
		}
		}
		else {
			numeros.add(valor);
		}
		
		System.out.println(valor);
		return valor;
	}
	
	
	public List <Autor> construirLista(List <Autor> listado){
	
		Autor autor = new Autor();

		autor.setId(aleatorio());
		autor.setNombre("Ket Follet");
		autor.setEdad(70);
		autor.setEmail("kent@educastur.org");
		listado.add(autor);
		
		
		
		Autor autor2 = new Autor();

		autor2.setId(aleatorio());
		autor2.setNombre("JK Rowling");
		autor2.setEdad(58);
		autor2.setEmail("jk@educastur.org");
		listado.add(autor2);
		
		
		

		Autor autor3 = new Autor();

		autor3.setId(aleatorio());
		autor3.setNombre("Perez Reverte");
		autor3.setEdad(62);
		autor3.setEmail("aurturo@educastur.org");
		listado.add(autor3);
		
	
		

		Autor autor4 = new Autor();
	
		autor4.setId(aleatorio());
		autor4.setNombre("Orson Scott Card");
		autor4.setEdad(62);
		autor4.setEmail("orson@educastur.org");
		listado.add(autor4);
		
		
		System.out.println("Autores creados");
		return listado;
	
	}
	
	
	
	
	
	public static List<Autor> getListaAutores() {
	
		if (lista == null) {
			new ListaAutores();
		}
		
		return lista;
	}
	
	
	
	
	
	public static void del(int id) {
		System.out.println("Entra en el metodo del");
		List <Autor> salida = new ArrayList <Autor>();
		Iterator <Autor> it = ListaAutores.lista.iterator();
		while(it.hasNext()) {
			Autor autor = it.next();
			int idAutor = autor.getId();
			if(idAutor == id){
				it.remove();
			}
			else {
				salida.add(autor);
			}
		}
		ListaAutores.lista = salida;
	}
}
