package org.ngarcia.webapp.controllers;

import jakarta.inject.Inject;
import org.ngarcia.webapp.configs.ProductoServicePrincipal;
import org.ngarcia.webapp.services.ProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import org.ngarcia.webapp.models.entities.Producto;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {

    @Inject
    //@Named("productoDefault")
    @ProductoServicePrincipal
    private ProductoService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nombreFiltro = req.getParameter("producto");
        //ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.findAllByName(nombreFiltro);
        
        Optional<Producto> encontrado = service.findOneByName(nombreFiltro);
        if(!encontrado.isPresent()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"No se encontró el producto " + nombreFiltro);
        }
        else {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("  <head>");
                out.println("    <meta charset=\"UTF-8\">");
                out.println("    <title>Productos</title>");
                out.println("  </head>");
                out.println("  <body>");
                out.println("    <h1>Productos</h1>");
                out.println("    <ul>");
                for( Producto p : productos) {
                    out.println("      <li>" + p.getNombre() + "</li>");    
                }
                out.println("    </ul>");
                out.println("    <h3>Producto encontrado: " + encontrado.get().getNombre() + "<h3>");
                out.println("  </body>");
                out.println("</html>");
            }
        }
    }
}
