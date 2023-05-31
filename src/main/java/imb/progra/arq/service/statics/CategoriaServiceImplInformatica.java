package imb.progra.arq.service.statics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import imb.progra.arq.entity.Categoria;
import imb.progra.arq.service.ICategoriaService;

@Service
public class CategoriaServiceImplInformatica implements ICategoriaService {
	public List<Categoria> mostrarCategorias() {
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		Categoria cat1 = new Categoria();
		cat1.setId(1);
		cat1.setNombre("Computadoras");
		listaCategoria.add(cat1);
		
		Categoria cat2 = new Categoria();
		cat2.setId(2);
		cat2.setNombre("Tablets");
		listaCategoria.add(cat2);

		Categoria cat3 = new Categoria();
		cat3.setId(3);
		cat3.setNombre("Telefonos");
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
