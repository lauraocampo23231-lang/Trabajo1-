package com.Trabajo1.demo.models;


public class Pedido {
    private String producto;
    private int cantidad;
    private double precio;
    private String estado;

    public Pedido() {}

    public Pedido(String producto, int cantidad, double precio, String estado) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
    }

    // Getters y Setters
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return cantidad * precio;
    }
}