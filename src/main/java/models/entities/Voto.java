package models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @ManyToOne
    @JoinColumn
    private Tema tema;
	
	public Voto(Integer id, String ip, Integer valor) {
        this.id = id;
        this.ip = ip;
        this.valor = valor;
    }
	
	public Voto(){	
	}
	
	public Integer getId() {
        return this.id;
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
                + valor + ", temaId=" + tema.getId() + "]";
    }

	
}
