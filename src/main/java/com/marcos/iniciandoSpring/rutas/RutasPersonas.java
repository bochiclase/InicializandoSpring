package com.marcos.iniciandoSpring.rutas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.marcos.iniciandoSpring.beans.ListaAutores;
import com.marcos.iniciandoSpring.beans.ListaPersonas;
import com.marcos.iniciandoSpring.beans.Persona;

@Controller
public class RutasPersonas {

	@GetMapping("/")
	public String paginaIndex(Model model) {
		List <Persona> personas = ListaPersonas.getPersonas();
		System.out.println("Enta a meter la lista");
		model.addAttribute("persona", personas);
		return "index";
	}
	
	
	@GetMapping("/del/{id}")
	public String borrarPersona(@PathVariable Integer id, Model model) {
		String nombre = ListaPersonas.del(id);
		List <Persona> personas = ListaPersonas.getPersonas();
		model.addAttribute("persona",personas);
		model.addAttribute("salida", nombre);
		return "index";
	}
	
	
	@GetMapping("/view/{id}")
	public String verPersona(@PathVariable Integer id, Model model) {
		Persona perso =ListaPersonas.viewPersona(id);
		model.addAttribute("persona", perso);
		return "persona";
	}
	
	
}
