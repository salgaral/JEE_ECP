package web.design.views.beans;

//import java.util.List;

import org.apache.logging.log4j.LogManager;

import models.entities.Tema;
import models.entities.Voto;
//import controllers.VotarController;

public class VotarView {

	private String errorMsg;

	private Tema tema;
	//private VotarController votarController;
	//private Voto voto;
	//private List<Tema> temas;
	
	private String[] nivelestudios;

	public VotarView() {
		//votarController = new VotarController();
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
	
	public String[] getNiveles() {
        return nivelestudios;
    }

    public void setNiveles(String[] nivelestudios) {
        this.nivelestudios = nivelestudios;
    }

	public void update(){
		//temas = votarController.listarTemas();
		LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
		this.nivelestudios = new String[] {"uno", "dos", "tres"};
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

	public void setVoto(Voto voto) {
		//this.voto = voto;
	}
}
