package web.design.views.beans;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.DeleteTemaController;

public class DeleteTemaView {
	
	private String errorMsg;

    private Tema tema;
    
    private DeleteTemaController deleteTemaController;

    public DeleteTemaView() {
    	deleteTemaController = new DeleteTemaController();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String process() {
        if (this.tema.getNombreTema() == ""){
        	this.errorMsg = "Ni el nombre del tema ni la pregunta pueden estar vacíos";
        	return "deleteTema";
        } else {
            LogManager.getLogger(AddTemaView.class).debug(
                    "Se accede a la capa de negocio para registrar un tema: " + tema);
            deleteTemaController.deleteTema(tema);
            return "home";
        }
    }
}