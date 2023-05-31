package imb.progra.arq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra.arq.entity.Categoria;
import imb.progra.arq.service.ICategoriaService;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {
	
	@Autowired
	ICategoriaService categorias;
	
	@GetMapping("/categorias")
	public List<Categoria> procesaElGet() {		
	
		return categorias.mostrarCategorias();
	}
	
	@PostMapping("/categorias")
	public Categoria procesaElPost(@RequestBody Categoria categoria) {
		categorias.guardarCategoría(categoria);
		return categoria;
	}

}
