package com.platzimarket.persistence.mapper;
import com.platzimarket.domain.Purchase;
import com.platzimarket.persistence.entity.Compra;
import org.mapstruct.*;

import javax.crypto.spec.PSource;
import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
/* indicamos que estamos trabajando con spring */
public interface PurchaseMapper {

    @Mappings({
           @Mapping(source ="idCompra",target = "purchaseId"),
           @Mapping(source = "idCliente", target="clientId"),
           @Mapping(source = "fecha", target = "date"),
           @Mapping(source = "medioPago", target = "paymentMethod"),
           @Mapping(source = "comentario", target = "comentary"),
           @Mapping(source = "estado", target = "active"),
           @Mapping(source = "comprasProducto", target = "items"), /* Lista, que utliza purchase item mapper */
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchase(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);

}
