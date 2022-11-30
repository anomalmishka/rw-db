package org.project.dao.custom.userProfile;

import lombok.RequiredArgsConstructor;
import org.project.model.UserProfile;
import org.project.model.UserProfile_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Repository
public class UserPrifileCustomDAOImpl implements UserPrifileCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public UserProfile findWhereUserId(Long userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfile> query = criteriaBuilder.createQuery(UserProfile.class);
        Root<UserProfile> root = query.from(UserProfile.class);
        Predicate predicateUserID = criteriaBuilder.equal(root.get(UserProfile_.userId), userId);
        query.where(predicateUserID);
        UserProfile singleResult = entityManager.createQuery(query).getSingleResult();
        entityManager.close();
        return singleResult;
    }
}
