package web.design.views.beans;

//import java.util.List;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;

import org.apache.logging.log4j.LogManager;

import controllers.VotarController;

public class Votar2View {

	private String errorMsg;

	private Tema tema;
	private Voto voto;

	private List<Voto> votos;

	//private List<NivelEstudio> nivelEstudios;
	private VotarController votarController;

	public Votar2View() {
		votarController = new VotarController();
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
	
	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	/*public List<NivelEstudio> getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(List<NivelEstudio> nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}
	*/
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public String process() {
//			LogManager.getLogger(AddTemaView.class).debug(
//					"Se accede a la capa de negocio para registrar un tema: " + tema);
//			votarController.deleteTema(tema);
			return "home";
//		}
	}
}