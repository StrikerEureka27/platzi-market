package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.Category;
import com.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    /* Mapeando la bd con lo que expondremos en terminos de dominio */

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    /* Para conversiones inversas */
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true) /* Debemos ignorar los atributos que no se maperan */
    Categoria toCategoria(Category category);


}
