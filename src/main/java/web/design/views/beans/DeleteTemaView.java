package web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.DeleteTemaController;

@ManagedBean
public class DeleteTemaView {
	
	private String errorMsg;

    private Tema tema;
    private List<Tema> temas;
    private int autenticacion;
    
    private DeleteTemaController deleteTemaController;

    public DeleteTemaView() {
    	deleteTemaController = new DeleteTemaController();
    }

    public String getErrorMsg() {
        return errorMsg;
    }
    
    public int getAutenticacion() {
		return autenticacion;
	}

	public void setAutenticacion(int autenticacion) {
		this.autenticacion = autenticacion;
	}

	public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public void update(){
		LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
		temas = new ArrayList<Tema>();
		temas = deleteTemaController.listarTemas();
	}

	public String process() {
        if (this.autenticacion != 666){
        	this.errorMsg = " La autenticación no es"
        			+ " correcta";
        	return "deleteTema";
        } else {
            LogManager.getLogger(AddTemaView.class).debug(
                    "Se accede a la capa de negocio para registrar un tema: " + tema);
            deleteTemaController.deleteTema(tema.getId());
            return "home";
        }
	}
}