package imb.progra.arq.service.statics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import imb.progra.arq.entity.Categoria;
import imb.progra.arq.service.ICategoriaService;

@Service
public class CategoriaServiceImplLibreria implements ICategoriaService {
	
	public List<Categoria> mostrarCategorias() {
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		// Categorías de Librería
		Categoria cat1 = new Categoria();
		cat1.setId(4);
		cat1.setNombre("Papelería");
		listaCategoria.add(cat1);
		
		Categoria cat2 = new Categoria();
		cat2.setId(5);
		cat2.setNombre("Carpetas");
		listaCategoria.add(cat2);

		Categoria cat3 = new Categoria();
		cat3.setId(6);
		cat3.setNombre("Lápices");
		listaCategoria.add(cat3);	
		
		
		return listaCategoria;
	}

	@Override
	public void guardarCategoría(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCategoria(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
