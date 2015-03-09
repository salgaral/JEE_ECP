package models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema {
	
	@Id
	private Integer id;
	
	private String nombreTema;
	private String pregunta;
	
	// Relación bidireccional: 1:0..n
    // relación mapeada en la otra entidad
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tema")
    private List<Voto> votos;
    
    public Tema() {
        super();
    }

    public Tema(Integer id, String nombreTema, String pregunta) {
        super();
        this.id = id;
        this.nombreTema = nombreTema;
        this.pregunta = pregunta;
    }

    public Integer getId() {
        return this.id;
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

    @Override
    public String toString() {
        return "Tema [id=" + id + ", nombre=" + nombreTema + ", pregunta=" + pregunta + ", votos=" + votos + "]";
    }
}
