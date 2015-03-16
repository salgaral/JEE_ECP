package web.design.views.beans;

import java.util.Map;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;

public class VotacionesView {

	private VerVotacionesController verVotacionesController;
	private Map<String, Integer> mapaNumeroVotos;
	
	public VotacionesView() {
    	verVotacionesController = new VerVotacionesController();
    }
	
	public Map<String, Integer> getMapaNumeroVotos() {
		return mapaNumeroVotos;
	}


	public void setMapaNumeroVotos(Map<String, Integer> mapaNumeroVotos) {
		this.mapaNumeroVotos = mapaNumeroVotos;
	}


	public String process() {
            LogManager.getLogger(AddTemaView.class).debug(
            		"Se accede a la capa de negocio para registrar un tema: " );
            mapaNumeroVotos = verVotacionesController.numeroVotosTema();
            return "verVotaciones";
    }
	
}
