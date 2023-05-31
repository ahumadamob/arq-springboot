package imb.progra.arq.service.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import imb.progra.arq.entity.Categoria;
import imb.progra.arq.repository.CategoriaRepository;
import imb.progra.arq.service.ICategoriaService;

@Service
@Primary
public class CategoriaServiceImplMysql implements ICategoriaService {
	
	@Autowired
	CategoriaRepository repo;

	@Override
	public List<Categoria> mostrarCategorias() {		
		return repo.findAll();

	}

	@Override
	public void guardarCategoría(Categoria categoria) {
		repo.save(categoria);
		
	}

	@Override
	public void eliminarCategoria(Integer id) {
		repo.deleteById(id);		
	}

}
