package models.daos.jpa;

public class TemaDaoJpa extends GenericDaoJpa<Tema,Integer>implements TemaDao {
	
	public TemaDaoJpa() {
        super(Tema.class);
    }
	
}
