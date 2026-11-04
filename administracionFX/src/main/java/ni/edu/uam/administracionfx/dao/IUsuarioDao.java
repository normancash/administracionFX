package ni.edu.uam.administracionfx.dao;

import ni.edu.uam.administracionfx.model.Usuario;

import java.util.List;

public interface IUsuarioDao {
    public void save(Usuario entity);
    public List<Usuario> listAll();
    public Usuario findById(String id);
    public Usuario update(Usuario entity);
    public void delete(Usuario entity);
}
