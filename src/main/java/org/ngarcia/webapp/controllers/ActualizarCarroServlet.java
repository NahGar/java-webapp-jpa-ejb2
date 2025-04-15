package org.ngarcia.webapp.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

import org.ngarcia.webapp.configs.ProductoServicePrincipal;
import org.ngarcia.webapp.models.*;
import org.ngarcia.webapp.models.entities.Producto;
import org.ngarcia.webapp.services.*;

@WebServlet("/carro/actualizar")
public class ActualizarCarroServlet extends HttpServlet {

    @Inject
    private Carro carro;

    @Inject
    //@Named("productoDefault")
    @ProductoServicePrincipal
    private ProductoService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        //if(req.getSession().getAttribute("carro") != null) {
        //se quita por inyección dependencia
        //Carro carro = (Carro) req.getSession().getAttribute("carro");
        //Connection conn = (Connection)  req.getAttribute("conn");
        //ProductoService service = new ProductoServiceJdbcImpl(conn);

        String[] idProductos = req.getParameterValues("id_producto");
        String[] cantidades = req.getParameterValues("cant_1");
        String[] deleteProductos = req.getParameterValues("delete_producto");

        int posicion = 0;
        for (String idProducto : idProductos) {

            Long id = Long.parseLong(idProducto);

            boolean borraProducto = false;
            //verifica si la linea se elimina
            if (deleteProductos != null) {
                for (String idDelete : deleteProductos) {
                    if (idProducto.equals(idDelete)) {
                        borraProducto = true;
                        break;
                    }
                }
            }

            if (borraProducto) {
                carro.deleteItem(id);
            } else {
                Optional<Producto> producto = service.findById(id);
                if (producto.isPresent()) {
                    ItemCarro item = new ItemCarro(Integer.parseInt(cantidades[posicion]), producto.get());
                    carro.updateItem(item);
                }
            }
            posicion++;
        }
        resp.sendRedirect(req.getContextPath()+"/carro/ver");
    }
}
