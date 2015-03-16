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
	private Map<String, Double> mapaMediaVotos;
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
	
	public Map<String, Double> mediaVotos(){
		
		mapaMediaVotos = new HashMap<String, Double>();
		votos = votoDao.findAll();
		int contBach=0, contFP, contUniv, contSecun;
		int sumaBach=0, sumaFP, sumaUniv, sumaSecun;
		
		for(Voto voto:votos){
			if(voto.getNivelestudio().equals(NivelEstudio.Bachillerato)){
				contBach++;
				sumaBach = sumaBach + voto.getValor();
			}
			else if(voto.getNivelestudio().equals(NivelEstudio.FormaciónProfesional)){
				contFP++;
				sumaFP = sumaFP + voto.getValor();
				
			}
			else if(voto.getNivelestudio().equals(NivelEstudio.Universitario)){
				contUniv++;
				sumaUniv = sumaUniv + voto.getValor();
				
			}
			else if(voto.getNivelestudio().equals(NivelEstudio.Secundaria)){
				contSecun++;
				sumaSecun = sumaFP + voto.getValor();
				
			}
		}
		
		
		
		for (Voto voto:votos){
			mapaMediaVotos.put(voto.getNivelestudio(), voto.getVotos().size());
		}
		return mapaMediaVotos;
		
	}
}
