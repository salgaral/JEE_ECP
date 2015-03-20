package models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
        super(Tema.class);
    }
	
	@Override
	public Tema buscarPregunta(String nombreTema){
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tema> criteriaQuery = criteriaBuilder.createQuery(Tema.class);
		
		Root <Tema> root = criteriaQuery.from(Tema.class);
		criteriaQuery.select(root);
		
		Predicate predicate = criteriaBuilder.equal(root.get("nombreTema"), nombreTema);
		criteriaQuery.where(predicate);
		criteriaQuery.select(root).where(predicate);
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
		
		
}