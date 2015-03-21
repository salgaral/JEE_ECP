package web.design.views.beans;

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
		System.out.println("Creadno votar2View bean");
		votarController = new VotarController();
		voto = new Voto();
	}
	
	public List<NivelEstudio> getNivelEstudios(){
		return Arrays.asList(NivelEstudio.values());
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
		//System.out.println("Process");
		idTema = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTema"));
		//System.out.println("El tema que me está llegando es: " + idTema);
		//votarController.addVoto(idTema, voto);
		voto.setIp(((HttpServletRequest) FacesContext.getCurrentInstance()
        .getExternalContext().getRequest()).getRemoteAddr());
		return process2();
	}
	
	public String process2() {
		System.out.println("Process");
		System.out.println("El tema que me está llegando es: " + idTema);
		votarController.addVoto(idTema, voto);
		return "home";
	}
}