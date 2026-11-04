package ni.edu.uam.administracionfx.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import ni.edu.uam.administracionfx.model.Usuario;

import java.util.List;

public class UsuarioDao implements IUsuarioDao{
    @Override
    public Usuario save(Usuario entity) {
        return null;
    }

    @Override
    public List<Usuario> listAll() {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery("from Usuario u"
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
    public Usuario findById(String id) {
        return null;
    }
}
