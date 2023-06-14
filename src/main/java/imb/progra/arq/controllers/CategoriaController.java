package imb.progra.arq.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import imb.progra.arq.entity.Categoria;
import imb.progra.arq.service.ICategoriaService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
	
	@Autowired
	ICategoriaService categoriaService;
	
	
	//public ResponseEntity<APIResponse<List<Project>>> 
	//APIResponse<List<Project>> response = new APIResponse<List<Project>>(200, addSingleMessage("No hay elementos"), projects);
	///return ResponseEntity.status(HttpStatus.OK).body(response);	
	
	/*
	@GetMapping
	public List<Categoria> mostrarTodos(){
		return categoriaService.buscarCategorias();
		
	} //Version1 del Get*/
	
	
	/*
	@GetMapping
	public ResponseEntity<List<Categoria>> mostrarTodos(){
		//return categoriaService.buscarCategorias();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(categoriaService.buscarCategorias());
	
	} //Version 2 del Get	
	*/
	
	
	@GetMapping
	public ResponseEntity<APIResponse<List<Categoria>>> mostrarTodos() {		
		APIResponse<List<Categoria>> response = new APIResponse<List<Categoria>>(200, null, categoriaService.buscarCategorias());
		return ResponseEntity.status(HttpStatus.OK).body(response);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<Categoria>> mostrarCategoriaPorId(@PathVariable("id") Integer id) {
		Categoria categoria = categoriaService.buscarCategoriaPorId(id);
		if(categoria == null) {
			List<String> messages = new ArrayList<>();
			messages.add("No se encontró la Categoría con id = " + id.toString());
			messages.add("Revise nuevamente el parámetro");
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
		}else {
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.OK.value(), null, categoria);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
		}		
	}
	
	@PostMapping
	public Categoria crearCategoria(@RequestBody Categoria categoria) {
		categoriaService.guardarCategoría(categoria);
		return categoria;
	}
	
	@PutMapping	
	public Categoria modificarCategoria(@RequestBody Categoria categoria) {
		categoriaService.guardarCategoría(categoria);
		return categoria;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarCategoria(@PathVariable("id") Integer id) {
		categoriaService.eliminarCategoria(id);
	}
	
	

}
