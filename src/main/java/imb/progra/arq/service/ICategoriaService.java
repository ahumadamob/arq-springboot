package imb.progra.arq.service;

import java.util.List;

import imb.progra.arq.entity.Categoria;

public interface ICategoriaService {
	public List<Categoria> mostrarCategorias();
	public void guardarCategoría(Categoria categoria);
	public void eliminarCategoria(Integer id);
	
}
