package imb.progra.arq.service.statics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import imb.progra.arq.entity.Categoria;
import imb.progra.arq.service.ICategoriaService;

@Service
public class CategoriaServiceImplComida implements ICategoriaService {

	@Override
	public List<Categoria> mostrarCategorias() {
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		Categoria cat1 = new Categoria();
		cat1.setId(7);
		cat1.setNombre("Sandwiches");
		listaCategoria.add(cat1);
		
		Categoria cat2 = new Categoria();
		cat2.setId(8);
		cat2.setNombre("Pizzas");
		listaCategoria.add(cat2);

		Categoria cat3 = new Categoria();
		cat3.setId(9);
		cat3.setNombre("Fideos");
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
