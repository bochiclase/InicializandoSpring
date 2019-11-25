package com.marcos.iniciandoSpring.rutas;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.iniciandoSpring.beans.Autor;
import com.marcos.iniciandoSpring.beans.ListaAutores;

@Controller
public class RutasBasicas {

	/*
	@Autowired
	Autor marcos;
	
	
	@Autowired
	Autor juan;
	*/
	
	
	
	
	/*
	@GetMapping("/start/{nombre}/{edad}")
	public String rutaBasicaInicial(@PathVariable String nombre,
									@PathVariable Integer edad,
									Model model) {
	*/

	
	@GetMapping("/start")
	public String rutaBasicaInicial(Model model) {
		
		List<Autor> listaAutores = ListaAutores.getListaAutores();
		model.addAttribute("autores",listaAutores);

		return "hola";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/del/{id}")
	public String borrar(@PathVariable Integer id, Model model){
		System.out.println("Entra en la ruta");
		ListaAutores.del(id);
		List<Autor> listaAutores = ListaAutores.getListaAutores();
		model.addAttribute("autores",listaAutores);
		
		return "hola";
	}
	
	

	/*
	
	@GetMapping("/autores/{id}")
	public String verAutor(	@PathVariable Integer id,
							Model model) {
		
		Autor autor = ListaAutores.getAutor(id);
		model.addAttribute("autor",autor);
		
		return "autor"; //html
	}	
	*/
	
	
	
	
	
	
	
	
	
	@GetMapping("/comienzo")
	public String rutaCero(	@RequestParam(required=false) Integer id, 
							@RequestParam(required=false) String nombre) {
		
		
		System.out.println("id: "+id);
		System.out.println("nombre: "+nombre);
		
		return "cero";
	}
	
	
	
	
}







/*
 * 	
	@GetMapping("/start/{nombre}/{edad}")
	public String rutaBasicaInicial(@PathVariable String nombre,
									@PathVariable Integer edad,
									Model model,
									HttpServletRequest  request) {
		
		model.addAttribute("nombre",nombre);
		model.addAttribute("edad",edad);
		
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(marcos);
		lista.add(juan);
		model.addAttribute("personas",lista);
		
		

		System.out.println(request.getServerName());
		System.out.println(request.getMethod());
		System.out.println(request.getRemoteAddr());	
		System.out.println(request.getServletPath());
		Enumeration<String>  cols = request.getPathInfo();
		while(cols.hasMoreElements()) {
			
			System.out.println(cols.nextElement());
		}

		
		return "hola";
	}
	*/
