package web.design.views.beans;

//import java.util.List;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
//import controllers.VotarController;
import models.utils.NivelEstudio;

import org.apache.logging.log4j.LogManager;

import controllers.VotarController;

public class VotarView {

	private String errorMsg;

	private Tema tema;
	private List<Tema> temas;
	private List<NivelEstudio> nivelEstudios;
	private VotarController votarController;
	//private Voto voto;
	
	public VotarView() {
		votarController = new VotarController();
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
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

	public List<NivelEstudio> getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(List<NivelEstudio> nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public void setVoto(Voto voto) {
		//this.voto = voto;
	}

	public void update(){
		//temas = votarController.listarTemas();
		LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
		nivelEstudios = new ArrayList<NivelEstudio>();
		nivelEstudios.add(NivelEstudio.Bachillerato);
		nivelEstudios.add(NivelEstudio.FormaciónProfesional);
		nivelEstudios.add(NivelEstudio.Secundaria);
		nivelEstudios.add(NivelEstudio.Universitario);
		temas = new ArrayList<Tema>();
		temas = votarController.listarTemas();
	}

	public String process() {
//		if (this.tema.getNombreTema() == ""){
//			this.errorMsg = "Ni el nombre del tema ni la pregunta pueden estar vacíos";
//			return "deleteTema";
//		} else {
//			LogManager.getLogger(AddTemaView.class).debug(
//					"Se accede a la capa de negocio para registrar un tema: " + tema);
//			votarController.deleteTema(tema);
			return "home";
//		}
	}
}
