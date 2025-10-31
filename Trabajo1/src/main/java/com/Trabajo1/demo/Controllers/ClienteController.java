package com.Trabajo1.demo.Controllers;


import com.Trabajo1.demo.Repository.ClienteRepository;
import com.Trabajo1.demo.models.Cliente;
import com.Trabajo1.demo.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Petición 1: Mostrar nombres de todos los clientes separados por coma
    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        List<Cliente> clientes = clienteRepository.obtenerTodos();
        String nombres = clientes.stream()
                .map(Cliente::getNombreCompleto)
                .collect(Collectors.joining(", "));

        model.addAttribute("titulo", "Petición 1: Nombres de Clientes");
        model.addAttribute("resultado", nombres);
        return "resultado";
    }

    // Petición 2: Datos estadísticos de los pedidos
    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        List<Cliente> clientes = clienteRepository.obtenerTodos();

        List<Pedido> todosPedidos = clientes.stream()
                .flatMap(cliente -> cliente.getPedidos().stream())
                .collect(Collectors.toList());

        long conteo = todosPedidos.size();
        double sumaTotal = todosPedidos.stream().mapToDouble(Pedido::getTotal).sum();
        double promedio = todosPedidos.stream().mapToDouble(Pedido::getTotal).average().orElse(0);
        double min = todosPedidos.stream().mapToDouble(Pedido::getTotal).min().orElse(0);
        double max = todosPedidos.stream().mapToDouble(Pedido::getTotal).max().orElse(0);

        String resultado = String.format(
                "Estadísticas de Pedidos:<br>" +
                        "Conteo: %d pedidos<br>" +
                        "Suma total: $%.2f<br>" +
                        "Promedio: $%.2f<br>" +
                        "Mínimo: $%.2f<br>" +
                        "Máximo: $%.2f",
                conteo, sumaTotal, promedio, min, max
        );

        model.addAttribute("titulo", "Petición 2: Estadísticas de Pedidos");
        model.addAttribute("resultado", resultado);
        return "resultado";
    }

    // Petición 3: Nombres de todos los productos de todos los pedidos
    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<Cliente> clientes = clienteRepository.obtenerTodos();

        List<String> productos = clientes.stream()
                .flatMap(cliente -> cliente.getPedidos().stream())
                .map(Pedido::getProducto)
                .distinct()
                .collect(Collectors.toList());

        String resultado = productos.stream().collect(Collectors.joining(", "));

        model.addAttribute("titulo", "Petición 3: Nombres de Todos los Productos");
        model.addAttribute("resultado", resultado);
        return "resultado";
    }

    // Petición 4: Consultas con anyMatch y noneMatch
    @GetMapping("/peticion4")
    public String peticion4(Model model) {
        List<Cliente> clientes = clienteRepository.obtenerTodos();

        boolean haySinPedidos = clientes.stream()
                .anyMatch(cli -> cli.getPedidos().isEmpty());

        boolean hayConMasDeUnPedido = clientes.stream()
                .anyMatch(cli -> cli.getPedidos().size() > 1);

        boolean ningunoConMasDeTresPedidos = clientes.stream()
                .noneMatch(cli -> cli.getPedidos().size() > 3);

        String resultado = String.format(
                "¿Hay clientes sin pedidos? %s<br>" +
                        "¿Hay clientes con más de un pedido? %s<br>" +
                        "¿Ningún cliente tiene más de tres pedidos? %s",
                haySinPedidos ? "Sí" : "No",
                hayConMasDeUnPedido ? "Sí" : "No",
                ningunoConMasDeTresPedidos ? "Sí" : "No"
        );

        model.addAttribute("titulo", "Petición 4: Consultas con Match");
        model.addAttribute("resultado", resultado);
        return "resultado";
    }

    // Petición 5: Pedido con mayor valor total
    @GetMapping("/peticion5")
    public String peticion5(Model model) {
        List<Cliente> clientes = clienteRepository.obtenerTodos();

        List<Pedido> todosPedidos = clientes.stream()
                .flatMap(cliente -> cliente.getPedidos().stream())
                .collect(Collectors.toList());

        Pedido pedidoMax = todosPedidos.stream()
                .reduce((ped1, ped2) ->
                        ped1.getTotal() > ped2.getTotal() ? ped1 : ped2)
                .orElse(null);

        String resultado = pedidoMax != null ?
                String.format("Pedido con mayor valor: %s - Cantidad: %d - Precio unitario: $%.2f - Total: $%.2f",
                        pedidoMax.getProducto(),
                        pedidoMax.getCantidad(),
                        pedidoMax.getPrecio(),
                        pedidoMax.getTotal()) :
                "No hay pedidos disponibles";

        model.addAttribute("titulo", "Petición 5: Pedido con Mayor Valor");
        model.addAttribute("resultado", resultado);
        return "resultado";
    }
}