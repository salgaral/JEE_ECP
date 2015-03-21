package web.design.views.beans;

import java.util.Map;

import javax.faces.bean.ManagedBean;

import models.utils.NivelEstudio;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;

@ManagedBean
public class VotacionesView {

	private VerVotacionesController verVotacionesController;
	private Map<String, Integer> mapaNumeroVotos;
	private Map<NivelEstudio, Double> mapaMediaVotos;
	
	public VotacionesView() {
    	verVotacionesController = new VerVotacionesController();
    }
	
	public Map<String, Integer> getMapaNumeroVotos() {
		return mapaNumeroVotos;
	}


	public void setMapaNumeroVotos(Map<String, Integer> mapaNumeroVotos) {
		this.mapaNumeroVotos = mapaNumeroVotos;
	}

	public Map<NivelEstudio, Double> getMapaMediaVotos() {
		return mapaMediaVotos;
	}

	public void setMapaMediaVotos(Map<NivelEstudio, Double> mapaMediaVotos) {
		this.mapaMediaVotos = mapaMediaVotos;
	}

	public String process() {
            LogManager.getLogger(AddTemaView.class).debug(
            		"Se accede a la capa de negocio para registrar un tema: " );
            mapaNumeroVotos = verVotacionesController.numeroVotosTema();
            mapaMediaVotos = verVotacionesController.mediaVotos();
            return "verVotaciones";
    }
	
}
