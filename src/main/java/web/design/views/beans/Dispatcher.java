package web.design.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;
import models.entities.Voto;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/web.jsp/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");

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
        case "addTema":
            AddTemaView addTemaView = new AddTemaView();
            request.setAttribute(action, addTemaView);
            view = action;
            break;
        case "deleteTema":
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
    	
    	request.setCharacterEncoding("UTF-8");
    	
        String action = request.getPathInfo().substring(1);
        String view = "home";
        Tema tema;
        switch (action) {
        case "votar":
        	Voto voto = new Voto();
        	//voto.setIp(request.getParameter("ip"));
        	//voto.setNivelestudio(NivelEstudio.valueOf(request.getParameter("nivelEstudios")));
        	//voto.setValor(Integer.valueOf(request.getParameter("valor")));
            //tema = new Tema();
            //tema.setNombreTema(request.getParameter("nombreTema"));
            voto.setNivelestudio2(request.getParameter("nivelestudio2"));
            VotarView votarView = new VotarView();
            votarView.setVoto(voto);
            //votarView.setTema(tema);
            request.setAttribute(action, votarView);
            view = votarView.process();
            break;
        case "addTema":
        	System.out.println("La pregunta que llega es: " + request.getParameter("pregunta"));
            AddTemaView addTemaView = new AddTemaView();
            tema = new Tema();
            tema.setNombreTema(request.getParameter("nombreTema"));
            tema.setPregunta(request.getParameter("pregunta"));
            addTemaView.setTema(tema);
            request.setAttribute(action, addTemaView);
            view = addTemaView.process();
            break;
        case "deleteTema":
            DeleteTemaView deleteTemaView = new DeleteTemaView();
            tema = new Tema();
            tema.setNombreTema(request.getParameter("nombreTema"));
            request.setAttribute(action, deleteTemaView);
            view = deleteTemaView.process();
            break;
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
