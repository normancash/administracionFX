package ni.edu.uam.administracionfx.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImplDao implements IDao{

    @Override
    public <T> List<T> getAll(String namedQuery, Class<T> clazz) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            TypedQuery<T> query = em.createNamedQuery(namedQuery,clazz);
            return query.getResultList();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
        return List.of();
    }

    @Override
    public <T> void insert(T entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
    }

    @Override
    public <T> T update(T entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            em.getTransaction().begin();
            T ent = em.merge(entity);
            em.flush();
            em.getTransaction().commit();
            return ent;
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return null;
    }

    @Override
    public <T> void remove(T entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
    }

    @Override
    public <T> T findById(Class<T> clazz, String id) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            T entity = em.find(clazz,id);
            return entity;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return null;
    }
}
