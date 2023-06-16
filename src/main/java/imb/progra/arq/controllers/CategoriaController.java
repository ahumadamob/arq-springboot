package imb.progra.arq.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra.arq.entity.Categoria;
import imb.progra.arq.service.ICategoriaService;


@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
	
	@Autowired
	ICategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<APIResponse<List<Categoria>>> mostrarTodos() {		
		APIResponse<List<Categoria>> response = new APIResponse<List<Categoria>>(200, null, categoriaService.buscarCategorias());
		return ResponseEntity.status(HttpStatus.OK).body(response);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<Categoria>> mostrarCategoriaPorId(@PathVariable("id") Integer id) {
		if(this.existe(id)) {
			Categoria categoria = categoriaService.buscarCategoriaPorId(id);
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.OK.value(), null, categoria);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No se encontró la Categoría con id = " + id.toString());
			messages.add("Revise nuevamente el parámetro");
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);			
		}
	
	}
	
	@PostMapping
	public ResponseEntity<APIResponse<Categoria>> crearCategoria(@RequestBody Categoria categoria) {
		if(this.existe(categoria.getId())) {
			List<String> messages = new ArrayList<>();
			messages.add("Ya existe una categoria con el ID = " + categoria.getId().toString());
			messages.add("Para actualizar utilice el verbo PUT");
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			categoriaService.guardarCategoría(categoria);
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.CREATED.value(), null, categoria);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);			
		}			
	}
	
	@PutMapping	
	public ResponseEntity<APIResponse<Categoria>> modificarCategoria(@RequestBody Categoria categoria) {
		if(this.existe(categoria.getId())) {
			categoriaService.guardarCategoría(categoria);
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.OK.value(), null, categoria);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No existe una categoria con el ID especificado");
			messages.add("Para crear una nueva utilice el verbo POST");
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<APIResponse<Categoria>> eliminarCategoria(@PathVariable("id") Integer id) {
		if(this.existe(id)) {
			categoriaService.eliminarCategoria(id);
			List<String> messages = new ArrayList<>();
			messages.add("La Categoria que figura en el cuerpo ha sido eliminada") ;			
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.OK.value(), messages, null);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No existe una categoria con el ID = " + id.toString());
			APIResponse<Categoria> response = new APIResponse<Categoria>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);			
		}
		
	}
	
	
	private boolean existe(Integer id) {
		if(id == null) {
			return false;
		}else{
			Categoria categoria = categoriaService.buscarCategoriaPorId(id);
			if(categoria == null) {
				return false;				
			}else {
				return true;
			}
		}
	}
	
	

}
