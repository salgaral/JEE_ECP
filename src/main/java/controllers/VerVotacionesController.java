package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;

public class VerVotacionesController {
	
	private List<Tema> temas;
	private List<Voto> votos;
	private Map<String, Integer> mapaNumeroVotos;
	private Map<NivelEstudio, Double> mapaMediaVotos;
	private TemaDao temaDao;
	private VotoDao votoDao;
	
	public VerVotacionesController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
	}
	
	public Map<String, Integer> numeroVotosTema(){
		
		mapaNumeroVotos = new HashMap<String, Integer>();
		temas = temaDao.findAll();
		for (Tema tema:temas){
			mapaNumeroVotos.put(tema.getNombreTema(), tema.getVotos().size());
		}
		
		return mapaNumeroVotos;
	}
	
	public Map<NivelEstudio, Double> mediaVotos(){
		
		mapaMediaVotos = new HashMap<NivelEstudio, Double>();
		votos = votoDao.findAll();
		
		int contBach = 0, contFP = 0, contUniv = 0, contSecun = 0;
		int sumaBach = 0, sumaFP = 0, sumaUniv = 0, sumaSecun = 0;
		double mediaBach = 0, mediaFP = 0, mediaUniv = 0, mediaSecun = 0;
		
		for(Voto voto:votos){
			switch(voto.getNivelestudio()){
			
			case Bachillerato:
				contBach++;
				sumaBach = sumaBach + voto.getValor();
				break;
			case FormaciónProfesional:
				contFP++;
				sumaFP = sumaFP + voto.getValor();
				break;
			case Universitario:
				contUniv++;
				sumaUniv = sumaUniv + voto.getValor();
				break;
			case Secundaria:
				contSecun++;
				sumaSecun = sumaFP + voto.getValor();
				break;
			}
		}
		
		if(contBach!=0){
			mediaBach = sumaBach / contBach;
		}
		if(contFP!=0){
			mediaFP = sumaFP / contFP;
		}
		if(contUniv!=0){
			mediaUniv = sumaUniv / contUniv;
		}
		if(contSecun!=0){
			mediaSecun = sumaSecun / contSecun;
		}
		
		mapaMediaVotos.put(NivelEstudio.Bachillerato, mediaBach);
		mapaMediaVotos.put(NivelEstudio.FormaciónProfesional, mediaFP);
		mapaMediaVotos.put(NivelEstudio.Universitario, mediaUniv);
		mapaMediaVotos.put(NivelEstudio.Secundaria, mediaSecun);
		
		return mapaMediaVotos;
		
	}
}
