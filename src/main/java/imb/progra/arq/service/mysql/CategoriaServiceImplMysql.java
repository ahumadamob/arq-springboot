package imb.progra.arq.service.mysql;

import java.util.List;
import java.util.Optional;

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
	public List<Categoria> buscarCategorias() {		
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

	@Override
	public Categoria buscarCategoriaPorId(Integer id) {
		Optional<Categoria> optional;
		optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

}
