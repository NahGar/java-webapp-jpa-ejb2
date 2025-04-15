package org.ngarcia.webapp.services;

import java.util.List;
import java.util.Optional;

import jakarta.ejb.Local;
import org.ngarcia.webapp.models.entities.Categoria;
import org.ngarcia.webapp.models.entities.Producto;

@Local
public interface ProductoService {

    List<Producto> listar();

    Optional<Producto> findOneByName(String name);

    List<Producto> findAllByName(String name);

    Optional<Producto> findById(Long id);

    void guardar(Producto producto);
    void eliminar(Long id);

    List<Categoria> listarCategoria();
    Optional<Categoria> findByIdCategoria(Long id);

    Optional<Producto> findBySku(String sku);
}
