package ni.edu.uam.administracionfx.service;

import ni.edu.uam.administracionfx.dao.IDao;
import ni.edu.uam.administracionfx.model.Usuario;

import java.util.List;

public class ServiceUsuario extends ServiceGeneric{
    public ServiceUsuario() {
        super();
    }

    public List<Usuario> getAll() {
        return dao.getAll("Usuario.findAll"
                ,Usuario.class);
    }
    public Usuario getById(String id) {
        return dao.findById(Usuario.class, id);
    }
    public void save(Usuario usuario) {
        dao.insert(usuario);
    }
}
