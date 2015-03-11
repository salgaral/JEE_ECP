package models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.utils.NivelEstudio;

@Entity
@Table(name = Tema.TABLE)
public class Tema {
	
	public static final String TABLE = "tema";

    public static final String ID = "ID";
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public static final String NOMBRETEMA = "NOMBRETEMA";
    private String nombreTema;

    public static final String PREGUNTA = "PREGUNTA";
    private String pregunta;
    
    public static final String NIVELDEESTUDIOS = "NIVELDEESTUDIOS";
    private NivelEstudio niveldeestudios;
	
    // Relación bidireccional: 1:0..n
    // relación mapeada en la otra entidad
    @OneToMany(cascade = CascadeType.ALL)
    private List<Voto> votos;
	
    public Tema(String nombreTema, String pregunta, List<Voto> votos) {
        super();
        this.nombreTema = nombreTema;
        this.pregunta = pregunta;
        this.votos = votos;
    }
    
    public Tema() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTema() {
        return this.nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }
    
    public String getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
    
    public NivelEstudio getNivelEstudios() {
        return this.niveldeestudios;
    }

    public void setNivelEstudios(NivelEstudio niveldeestudios) {
        this.niveldeestudios = niveldeestudios;
    }

    @Override
    public String toString() {
        return "Tema [id=" + id + ", nombre=" + nombreTema + ", pregunta=" + pregunta + ", votos=" + votos + "]";
    }
}
