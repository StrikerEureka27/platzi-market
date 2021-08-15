package com.platzimarket.persistence;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.repository.ProductRepository;
import com.platzimarket.persistence.crud.ProductoCrudRepository;
import com.platzimarket.persistence.entity.Producto;
import com.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Una vez que vemos las tags @Override es que nuestro ProductCrudRepository ya esta orientado al dominio.
@Repository //Interactua con la bd por lo que debdemos agregar su indentificación
public class ProductoRepository implements ProductRepository {

    /* No estamos creando los objetos, por lo tanto debdemos hacer una inyeccion de dependencias */
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;
    /* Unicamente debdemos de utilizar con Componentes de Spring*/

    // Por defecto que se incluyen en los queryMethod's
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
        // Se casteo por que el metodo regresa un iterable.
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findBycantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods)); /* Mapeo los productos, retorna un optional */
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prods -> mapper.toProduct(prods));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product); /* Mapeamos a la inversa */
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /* -- Perzonalizado desde la interfaz ProductCrudRepository --
    (Al momento de implementar el mapping debemos sobre escribir estos metodos, para que queden en terminos de dominio)
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRepository.findBycantidadStockLessThanAndEstado(cantidad, estado);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }*/

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
