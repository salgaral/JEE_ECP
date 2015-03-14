package web.design.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/web.jsp/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "votar":
            VotarView votarView = new VotarView();
            request.setAttribute(action, votarView);
            view = action;
            break;
        case "verVotaciones":
            VotacionesView votacionesView = new VotacionesView();
            request.setAttribute(action, votacionesView);
            view = action;
            break;
        case "incorporarTema":
            AddTemaView addTemaView = new AddTemaView();
            request.setAttribute(action, addTemaView);
            view = action;
            break;
        case "eliminarTema":
            DeleteTemaView deleteTemaView = new DeleteTemaView();
            request.setAttribute(action, deleteTemaView);
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
        case "votar":
            Persona persona = new Persona();
            persona.setId(Integer.valueOf(request.getParameter("id")));
            persona.setNombre(request.getParameter("nombre"));
            persona.setRol(request.getParameter("rol"));
            VotarView votarView = new VotarView();
            votarView.setPersona(persona);
            request.setAttribute(action, votarView);
            view = votarView.process();
            break;
        case "incorporarTema":
            Tema tema = new Tema();
            persona.setId(Integer.valueOf(request.getParameter("id")));
            persona.setNombre(request.getParameter("nombre"));
            persona.setRol(request.getParameter("rol"));
            AddTemaView addTemaView = new AddTemaView();
            addTemaView.setPersona(persona);
            request.setAttribute(action, addTemaView);
            view = addTemaView.process();
            break;
        case "eliminarTema":
            DeleteTemaView deleteTemaView = new DeleteTemaView();
            deleteTemaView.setRol(request.getParameter("rol"));
            request.setAttribute(action, deleteTemaView);
            view = deleteTemaView.process();
            break;
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
