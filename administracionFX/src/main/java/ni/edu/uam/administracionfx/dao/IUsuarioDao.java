package ni.edu.uam.administracionfx.dao;

import ni.edu.uam.administracionfx.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDao {
    public void save(Usuario entity);
    public List<Usuario> listAll();
    public Usuario update(Usuario entity);
    public void delete(Usuario entity);
    public Optional<Usuario> findById(String id);
}
