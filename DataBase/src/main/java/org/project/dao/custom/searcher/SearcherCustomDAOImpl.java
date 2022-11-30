package org.project.dao.custom.searcher;

import lombok.RequiredArgsConstructor;
import org.project.dto.searcher.Searcher;
import org.project.model.PassengerProfile;
import org.project.model.PassengerProfile_;
import org.project.model.UserProfile;
import org.project.model.UserProfile_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class SearcherCustomDAOImpl implements SearcherCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<UserProfile> findUserProfile(Searcher searcher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfile> query = criteriaBuilder.createQuery(UserProfile.class);
        Root<UserProfile> root = query.from(UserProfile.class);
        String findContent = searcher.getFindContent();
        Predicate predicate = criteriaBuilder.equal(root.get(UserProfile_.profilename), findContent);
        query.where(predicate).distinct(true);
        List<UserProfile> resultList = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<PassengerProfile> findPassengerProfile(Searcher searcher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PassengerProfile> query = criteriaBuilder.createQuery(PassengerProfile.class);
        Root<PassengerProfile> root = query.from(PassengerProfile.class);
        String findContent = searcher.getFindContent();
        Predicate predicate = criteriaBuilder.equal(root.get(PassengerProfile_.passengerlastname), findContent);
        query.where(predicate).distinct(true);
        List<PassengerProfile> resultList = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return resultList;
    }
}
