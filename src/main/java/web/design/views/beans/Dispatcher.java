package web.design.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;


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
        	VotarView votarView = new VotarView();
            tema = new Tema();
            tema.setId(Integer.valueOf(request.getParameter("id")));
            votarView.setTema(tema);  
            view = votarView.process();  
            request.setAttribute(action, votarView);
            break;
            
        case "votar2": 
        	Votar2View votar2View = new Votar2View();
        	Voto voto = new Voto();
        	voto.setIp(request.getRemoteAddr());
        	voto.setNivelestudio(NivelEstudio.valueOf(request.getParameter("nivelEstudios")));
        	voto.setValor(Integer.valueOf(request.getParameter("valor")));
            votar2View.setVoto(voto);
            votar2View.setIdTema(Integer.valueOf(request.getParameter("idTema")));
            request.setAttribute(action, votar2View);
            view = votar2View.process2();
            break;
            
        case "addTema":
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
            tema.setId(Integer.parseInt(request.getParameter("nombreTema")));
            deleteTemaView.setTema(tema);
            deleteTemaView.setAutenticacion(Integer.parseInt(request.getParameter("autenticacion")));
            request.setAttribute(action, deleteTemaView);
            view = deleteTemaView.process();
            break;
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
