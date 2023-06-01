package imb.progra.arq.service;

import java.util.List;

import imb.progra.arq.entity.Categoria;

public interface ICategoriaService {
	public List<Categoria> buscarCategorias();
	public Categoria buscarCategoriaPorId(Integer id);
	public void guardarCategoría(Categoria categoria);
	public void eliminarCategoria(Integer id);
	
}
