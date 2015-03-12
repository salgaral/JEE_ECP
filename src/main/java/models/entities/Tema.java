package models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
    // Relación bidireccional: 1:0..n
    // relación mapeada en la otra entidad
    @OneToMany(cascade = CascadeType.ALL)
    private List<Voto> votos;
	
    public Tema(String nombreTema, String pregunta) {
        super();
        this.nombreTema = nombreTema;
        this.pregunta = pregunta;
        this.votos = new ArrayList<Voto>();
    }
    
    public Tema() {
    }

    public Integer getId() {
        return id;
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
    
    public void asignarVotos(List<Voto> votos){
    	this.votos = votos;
    }

    @Override
    public String toString() {
        return "Tema [id=" + id + ", nombre=" + nombreTema + ", pregunta=" + pregunta + ", votos=" + votos + "]";
    }
    
    @Override
    public boolean equals(Object o){
    	Tema t = (Tema) o;
		return id.equals(t.id) && nombreTema.equals(t.nombreTema) && pregunta.equals(t.pregunta) && votos.equals(t.votos);
    }
}
