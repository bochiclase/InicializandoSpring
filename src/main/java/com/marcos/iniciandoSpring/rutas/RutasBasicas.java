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
import com.marcos.iniciandoSpring.beans.ListaPersonas;
import com.marcos.iniciandoSpring.beans.Persona;

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

	
	/*METODO PARA MOSTRAR UN AUTOR*/
	@GetMapping("/autores/{id}")
	public String mostrarautor(@PathVariable Integer id, Model model) {
		Autor autor = ListaAutores.getAutor(id);
		model.addAttribute("autor", autor);
		return "autor";
	}
	
	
	
	/**
	 *METODO QUE LSITA LOS AUTORES GUARDADOS 
	 */
	
	/*He camiado el get mapping para que funcione la ruta de personas por defecto este mapping debe de tener
	 * 
	 * (/)
	 * 
	 * */
	@GetMapping("/inicio")
	public String rutaBasicaInicial(Model model) {
		
		List<Autor> listaAutores = ListaAutores.getListaAutores();
		model.addAttribute("autores",listaAutores);

		return "hola";
	}
	
	
	
	/*
	 * METODO QUE BORRAR UN AUTOR DE LA LISTA POR ID
	 * */
	
	@GetMapping("/delautor/{id}")
	public String borrar(@PathVariable Integer id, Model model){
		System.out.println("Entra en borrar");
		Autor salida = ListaAutores.del(id);
		List<Autor> listaAutores = ListaAutores.getListaAutores();
		model.addAttribute("autores",listaAutores);
		model.addAttribute("salidas",salida);
		
		return "hola";
	}
	
	
	
	
	/*
	 * METODO QUE EDITA UN AUTOR MEDIANTE UN ID (HAY QUE PASARLE LOS PARAMETROS NUEVOS POR LA URL)
	 * 
	 * */
	
	@GetMapping("/edit/{id}/{nombre}/{edad}/{email}")
	public String edit(@PathVariable Integer id, @PathVariable String nombre, @PathVariable Integer edad, @PathVariable String email, Model model) {
		System.out.println("Entra en editar");
		ListaAutores.edit(id, nombre, edad, email);
		List <Autor> listaAutores = ListaAutores.getListaAutores();
		model.addAttribute("autores",listaAutores);
		return "hola";
	}
	
	
	
	/*METODO PARA CARGAR UNA PAGINA DE INICIO PARA PRUEBAS*/
	
	
	@GetMapping("/comienzo")
	public String rutaCero(	@RequestParam(required=false) Integer id, 
							@RequestParam(required=false) String nombre) {
		
		
		System.out.println("id: "+id);
		System.out.println("nombre: "+nombre);
		
		return "cero";
	}
	
	
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
