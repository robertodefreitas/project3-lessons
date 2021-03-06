package my.solution.project3.lesson4.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import my.solution.project3.lesson4.model.Delivery;
import my.solution.project3.lesson4.model.Plant;
import my.solution.project3.lesson4.model.RecipientAndPrice;

@Repository
@Transactional
public class DeliveryRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    public Delivery merge(Delivery delivery){
        return entityManager.merge(delivery);
    }

    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

    public List<Delivery> findDeliveriesByName(String name){
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    // One possible way to solve this - query a list of Plants with deliveryId matching
    // the one provided and sum their prices.

    /**
     * MY-NOTE
     * following Solution is important, if we use PostgreSQL DB (s. row below)
     *
     * ERROR:
     * Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed;
     * nested exception is org.springframework.dao.InvalidDataAccessResourceUsageException:
     * could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException:
     * could not extract ResultSet] with root cause
     *
     * SOLUTION:
     * .groupBy(root.get("delivery").get("name"))
     */
    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);

        query.select(
            cb.construct(
                RecipientAndPrice.class,
                root.get("delivery").get("name"),
                cb.sum(root.get("price"))))
        .where(cb.equal(root.get("delivery").get("id"), deliveryId))
        .groupBy(root.get("delivery").get("name"));

        return entityManager.createQuery(query).getSingleResult();
    }
}