package com.platzimarket.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "id")
    private Integer idCliente;

    @Column(name = "nombre")
    private String nombreCliente;

    @Column(name = "apellidos")
    private String apellidoCliente;

    @Column(name = "celular")
    private Integer celular;

    @Column(name = "direccion")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
