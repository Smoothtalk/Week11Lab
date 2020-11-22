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
}
