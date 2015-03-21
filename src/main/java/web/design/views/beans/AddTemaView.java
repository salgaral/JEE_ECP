package web.design.views.beans;

import javax.faces.bean.ManagedBean;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.AddTemaController;

@ManagedBean
public class AddTemaView {
    private String errorMsg;

    private Tema tema;

    private AddTemaController addTemaController;
    
    public AddTemaView() {
    	addTemaController = new AddTemaController();
    	tema = new Tema();
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
        if (this.tema.getNombreTema() == "" || this.tema.getPregunta() == ""){
        	this.errorMsg = "Ni el nombre del tema ni la pregunta pueden estar vac�os";
        	return "addTema";
        } else {
            LogManager.getLogger(AddTemaView.class).debug(
            		"Se accede a la capa de negocio para registrar un tema: " + tema);
            addTemaController.addTema(tema);
            return "home";
        }
    }
}