package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.Product;
import com.platzimarket.persistence.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category") /* ya tiene su mapeador, agregamos uses*/
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos); /*Como ya esta mapeado unicamente indicamos el preceso inverso*/

    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
