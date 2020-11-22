package dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.User;


public class UserDB {
    public User get(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    public void setUserUUID(User user, String UUID){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            user.setResetPasswordUuid(UUID);
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch(Exception e){
            trans.rollback();
        }
    }

    public void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        }
    }

    public User getByUUID(String uuid) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            return em.createNamedQuery("User.findByResetPasswordUuid", User.class).setParameter("resetPasswordUuid", uuid).getResultList().get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
