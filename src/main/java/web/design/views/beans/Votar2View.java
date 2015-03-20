package web.design.views.beans;

import java.util.List;

import models.entities.Voto;
import controllers.VotarController;

public class Votar2View {

	private String errorMsg;

	private Integer idTema;
	private Voto voto;

	private List<Voto> votos;

	private VotarController votarController;

	public Votar2View() {
		votarController = new VotarController();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public String process() {
		votarController.addVoto(idTema, voto);
		return "home";
	}
}