package web.design.views.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import models.entities.Voto;
import models.utils.NivelEstudio;
import controllers.VotarController;

@ManagedBean
public class Votar2View {

	private String errorMsg;
	@ManagedProperty("#{votarView.tema.id}")
	private int idTema;
	private Voto voto;

	private List<Voto> votos;
	
	private VotarController votarController;

	public Votar2View() {
		votarController = new VotarController();
		voto = new Voto();
	}
	
	public List<NivelEstudio> getNivelEstudios(){
		return Arrays.asList(NivelEstudio.values());
	}
	
	public List<Integer> getPuntuacion() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=10;i++){
			list.add(i);
		}
		return list;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
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
		idTema = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTema"));
		voto.setIp(((HttpServletRequest) FacesContext.getCurrentInstance()
        .getExternalContext().getRequest()).getRemoteAddr());
		return process2();
	}
	
	public String process2() {
		votarController.addVoto(idTema, voto);
		return "home";
	}
}