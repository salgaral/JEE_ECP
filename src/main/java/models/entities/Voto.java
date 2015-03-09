package models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Voto {
	
	@Id
	private Integer id;
	
	private String ip;
	private Integer valor;
	
	@ManyToOne
	@JoinColumn(name = USER_ID)
	private Tema tema;
	
	public static final String USER_ID = "USER_ID";
	
	public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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
	
}
