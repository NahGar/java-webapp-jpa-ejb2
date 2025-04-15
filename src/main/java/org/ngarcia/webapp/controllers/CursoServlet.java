package org.ngarcia.webapp.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.ngarcia.webapp.models.entities.Curso;
import org.ngarcia.webapp.services.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/curso/listar")
public class CursoServlet extends HttpServlet {

   @Inject
   private CursoService service;

   private static final Logger logger = Logger.getLogger(CursoServlet.class.getName());

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      //Connection conn = (Connection)  req.getAttribute("conn");
      //CursoService service = new CursoServiceImpl(conn);

      List<Curso> cursos = service.listar();

      req.setAttribute("cursos",cursos);
      req.setAttribute("titulo","Lista de cursos");

      getServletContext().getRequestDispatcher("/listar-cursos.jsp").forward(req,resp);

   }
}
