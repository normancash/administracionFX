package ni.edu.uam.administracionfx.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import ni.edu.uam.administracionfx.model.Usuario;

import java.util.List;
import java.util.Optional;

public class UsuarioDao implements IUsuarioDao{
    @Override
    public void save(Usuario entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        Usuario e = null;
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<Usuario> listAll() {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll"
                    , Usuario.class);
            return query.getResultList();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return List.of();
    }

    @Override
    public Optional<Usuario> findById(String id) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findById", Usuario.class);
            query.setParameter(1,id);
            Usuario u = query.getSingleResultOrNull();
            return Optional.of(u);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public Usuario update(Usuario entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            em.getTransaction().begin();
            Usuario ent = em.merge(entity);
            em.getTransaction().commit();
            return ent;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return null;
    }

    @Override
    public void delete(Usuario entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }
}
