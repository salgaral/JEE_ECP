package models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import models.utils.NivelEstudio;

@Entity
@Table(name = Voto.TABLE)
public class Voto {
	
	public static final String TABLE = "voto";
	
	public static final String ID = "ID";
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public static final String IP = "IP";

    @Column(name = IP)
    private String ip;

    public static final String VALOR = "VALOR";

    @Column(name = VALOR)
    private Integer valor;
    
    public static final String NIVELESTUDIO = "NIVELESTUDIO";

    @Column(name = NIVELESTUDIO)
    private NivelEstudio nivelestudio;
	
	public Voto(String ip, Integer valor, NivelEstudio nivelestudio) {
        this.ip = ip;
        this.valor = valor;
        this.nivelestudio= nivelestudio;
    }
	
	public Voto(){	
	}
	
	public Integer getId() {
        return this.id;
    }
    
    public NivelEstudio getNivelestudio() {
		return nivelestudio;
	}

	public void setNivelestudio(NivelEstudio nivelestudio) {
		this.nivelestudio = nivelestudio;
	}

	public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
	
    public Integer getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Voto [id=" + id + ", ip=" + ip + ", valor="
                + valor + " nivel de estudio " + nivelestudio +  "]";
    }
    
    @Override
    public boolean equals(Object o){
    	Voto v = (Voto) o;
		return id.equals(v.id) && ip.equals(v.ip) && valor.equals(v.valor) && nivelestudio.equals(v.nivelestudio);
    }

	
}
