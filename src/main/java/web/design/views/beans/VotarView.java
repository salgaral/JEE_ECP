package web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import models.entities.Tema;
import models.utils.NivelEstudio;

import org.apache.logging.log4j.LogManager;

import controllers.VotarController;

@ManagedBean
public class VotarView {

	private String errorMsg;

	private Tema tema;
	private List<Tema> temas;
	private List<NivelEstudio> nivelEstudios;
	private List<Integer> puntuacion;


	private VotarController votarController;

	public VotarView() {
		votarController = new VotarController();
		tema = new Tema();
		puntuacion = new ArrayList<Integer>();
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

	public List<Integer> getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(List<Integer> puntuacion) {
		this.puntuacion = puntuacion;
	}

	@PostConstruct
	public void update(){
		LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar votos");
		temas = new ArrayList<Tema>();
		temas = votarController.listarTemas();
		
	}

	public String process() {
			nivelEstudios = new ArrayList<NivelEstudio>();
			nivelEstudios.add(NivelEstudio.Bachillerato);
			nivelEstudios.add(NivelEstudio.FormaciónProfesional);
			nivelEstudios.add(NivelEstudio.Secundaria);
			nivelEstudios.add(NivelEstudio.Universitario);
			
			
			tema = votarController.buscarPregunta(tema.getId());	
			return "votar2";
	}
}