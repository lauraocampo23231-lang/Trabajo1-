
package com.Trabajo1.demo.Repository;


import com.Trabajo1.demo.models.Cliente;
import com.Trabajo1.demo.models.Pedido;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ClienteRepository {
    private List<Cliente> clientes;

    public ClienteRepository() {
        cargarClientes();
    }

    private void cargarClientes() {
        // Crear pedidos
        Pedido pedido1 = new Pedido("Laptop", 1, 1200, "Entregado");
        Pedido pedido2 = new Pedido("Mouse", 2, 25, "Pendiente");
        Pedido pedido3 = new Pedido("Teclado", 1, 80, "Entregado");
        Pedido pedido4 = new Pedido("Monitor", 1, 300, "Procesando");
        Pedido pedido5 = new Pedido("Auriculares", 3, 50, "Entregado");
        Pedido pedido6 = new Pedido("Tablet", 1, 400, "Pendiente");
        Pedido pedido7 = new Pedido("Smartphone", 2, 600, "Entregado");
        Pedido pedido8 = new Pedido("Impresora", 1, 200, "Procesando");
        Pedido pedido9 = new Pedido("Cámara", 1, 350, "Entregado");
        Pedido pedido10 = new Pedido("Altavoz", 2, 120, "Pendiente");

        // Crear clientes con diferentes cantidades de pedidos
        Cliente cliente1 = new Cliente("Juan Pérez", 30, "Masculino", 5000);
        cliente1.agregarPedido(pedido1);
        cliente1.agregarPedido(pedido2);

        Cliente cliente2 = new Cliente("María García", 25, "Femenino", 3000);
        cliente2.agregarPedido(pedido3);

        Cliente cliente3 = new Cliente("Carlos López", 35, "Masculino", 7000);
        cliente3.agregarPedido(pedido4);
        cliente3.agregarPedido(pedido5);
        cliente3.agregarPedido(pedido6);

        Cliente cliente4 = new Cliente("Ana Martínez", 28, "Femenino", 4000);
        // Sin pedidos

        Cliente cliente5 = new Cliente("Pedro Rodríguez", 40, "Masculino", 6000);
        cliente5.agregarPedido(pedido7);

        Cliente cliente6 = new Cliente("Laura Hernández", 32, "Femenino", 3500);
        cliente6.agregarPedido(pedido8);
        cliente6.agregarPedido(pedido9);

        Cliente cliente7 = new Cliente("Miguel Sánchez", 45, "Masculino", 8000);
        // Sin pedidos

        Cliente cliente8 = new Cliente("Sofia Díaz", 29, "Femenino", 4500);
        cliente8.agregarPedido(pedido10);

        Cliente cliente9 = new Cliente("David Torres", 33, "Masculino", 5500);
        cliente9.agregarPedido(new Pedido("Smartwatch", 1, 150, "Entregado"));
        cliente9.agregarPedido(new Pedido("Funda", 2, 20, "Entregado"));

        Cliente cliente10 = new Cliente("Elena Ruiz", 27, "Femenino", 3200);
        cliente10.agregarPedido(new Pedido("Laptop", 1, 1000, "Procesando"));
        cliente10.agregarPedido(new Pedido("Mouse", 1, 30, "Entregado"));

        Cliente cliente11 = new Cliente("Jorge Gómez", 38, "Masculino", 7500);
        cliente11.agregarPedido(new Pedido("Tablet", 2, 800, "Pendiente"));
        cliente11.agregarPedido(new Pedido("Teclado", 1, 90, "Entregado"));
        cliente11.agregarPedido(new Pedido("Monitor", 1, 350, "Procesando"));

        Cliente cliente12 = new Cliente("Carmen Vargas", 31, "Femenino", 4200);
        // Sin pedidos

        Cliente cliente13 = new Cliente("Francisco Castro", 42, "Masculino", 6800);
        cliente13.agregarPedido(new Pedido("Smartphone", 1, 700, "Entregado"));

        Cliente cliente14 = new Cliente("Isabel Ortega", 26, "Femenino", 3800);
        cliente14.agregarPedido(new Pedido("Auriculares", 1, 60, "Entregado"));
        cliente14.agregarPedido(new Pedido("Altavoz", 1, 100, "Pendiente"));

        Cliente cliente15 = new Cliente("Roberto Morales", 36, "Masculino", 5200);
        // Sin pedidos

        Cliente cliente16 = new Cliente("Patricia Silva", 34, "Femenino", 4700);
        cliente16.agregarPedido(new Pedido("Impresora", 1, 250, "Procesando"));
        cliente16.agregarPedido(new Pedido("Tinta", 3, 45, "Entregado"));

        Cliente cliente17 = new Cliente("Daniel Herrera", 39, "Masculino", 5900);
        cliente17.agregarPedido(new Pedido("Cámara", 1, 400, "Entregado"));
        cliente17.agregarPedido(new Pedido("Tripode", 1, 80, "Entregado"));
        cliente17.agregarPedido(new Pedido("Memoria", 2, 40, "Pendiente"));

        Cliente cliente18 = new Cliente("Rosa Mendoza", 30, "Femenino", 4100);
        // Sin pedidos

        Cliente cliente19 = new Cliente("Alejandro Rios", 44, "Masculino", 7200);
        cliente19.agregarPedido(new Pedido("Laptop", 1, 1500, "Procesando"));
        cliente19.agregarPedido(new Pedido("Mouse", 1, 35, "Entregado"));
        cliente19.agregarPedido(new Pedido("Teclado", 1, 95, "Entregado"));
        cliente19.agregarPedido(new Pedido("Monitor", 1, 400, "Pendiente"));

        Cliente cliente20 = new Cliente("Teresa Flores", 37, "Femenino", 5300);
        cliente20.agregarPedido(new Pedido("Tablet", 1, 450, "Entregado"));

        this.clientes = Arrays.asList(
                cliente1, cliente2, cliente3, cliente4, cliente5,
                cliente6, cliente7, cliente8, cliente9, cliente10,
                cliente11, cliente12, cliente13, cliente14, cliente15,
                cliente16, cliente17, cliente18, cliente19, cliente20
        );
    }

    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}